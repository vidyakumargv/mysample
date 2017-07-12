package com.srh.test.action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fasterxml.jackson.databind.ObjectMapper;


public class TestDAOACTION extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DataSource ds = null;
		Connection con = null;
		HttpSession sess = request.getSession(false);
		DataExtractorSessBO bo = null;
		DataInsertSessBO boint = null;
		int result = 0;
		String frmJsp = request.getParameter("frmJsp");
		String method = request.getParameter("method");
		System.out.println("method = " + method + " From Jsp = " + frmJsp);
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/testbed",
			// "root", "root");
			try {
				String driver = "com.mysql.jdbc.Driver";
				String connection = "jdbc:mysql://localhost:3306/testbed";
				String user = "root";
				String password = "root";
				Class.forName(driver);
				con = DriverManager.getConnection(connection, user, password);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// NOTE:
			// Can use if conditions for writing Single Generic Action, for
			// handling Multiple Requests.
			// Ex: if( (fromJsp="AllReqPrss") && (fromAction="exeReq") )
			HttpSession session = request.getSession();

			if (method.equals("getClId") || method.equals("getSmId")
					|| method.equals("getSlNo") || method.equals("getTestDAO")
					|| method.equals("runQuery")) {

				// Clear session before set
				session.setAttribute("HashObjClId", new HashMap());
				session.setAttribute("HashObjSmId", new HashMap());
				session.setAttribute("HashObjSlNo", new HashMap());
				session.setAttribute("HashObjTestDaoData", new HashMap());
				session.setAttribute("HashObjQuery", new HashMap());

				bo = BusinessManager.getBusinessObject(method);
				result = bo.executeAndDispToSO(con, sess, request, method);

			} else if (method.equals("commit")) {

				boint = BusinessManagerInsert.getBusinessObject(method);
				result = boint.insertFrmSessObj(con, sess, request, method);
				/*
				 * session.setAttribute("HashObjClId", new HashMap());
				 * session.setAttribute("HashObjSmId", new HashMap());
				 * session.setAttribute("HashObjSlNo", new HashMap());
				 * session.setAttribute("HashObjTestDaoData", new HashMap());
				 * session.setAttribute("HashObjQuery", new HashMap());
				 */
			}

		} catch (Exception e) {
			System.out.println("Exception occur in calling Business Manager "
					+ e);
		}

		if (result == 0) {

			response.setContentType("application/json");
			response.setHeader("cache-control", "no-cache");
			response.setStatus(420);
			PrintWriter writer = response.getWriter();
			// String jsonString = new ObjectMapper().writeValueAsString("{");
			// writer.println(jsonString);
			// System.out.println(jsonString);
			writer.flush();
			return null;

		}
		HttpSession session = request.getSession();
		if (method.equals("getClId")) {

			// HttpSession session=request.getSession();
			HashMap HashObjClId = (HashMap) session.getAttribute("HashObjClId");
			response.setContentType("application/json");
			response.setHeader("cache-control", "no-cache");
			PrintWriter writer = response.getWriter();
			String jsonString = new ObjectMapper()
					.writeValueAsString(HashObjClId);
			writer.println(jsonString);
			System.out.println(jsonString);
			writer.flush();
		} else if (method.equals("getSmId")) {

			// HttpSession session=request.getSession();
			HashMap HashObjSmId = (HashMap) session.getAttribute("HashObjSmId");
			response.setContentType("application/json");
			response.setHeader("cache-control", "no-cache");
			PrintWriter writer = response.getWriter();
			String jsonString = new ObjectMapper()
					.writeValueAsString(HashObjSmId);
			writer.println(jsonString);
			System.out.println(jsonString);
			writer.flush();
		} else if (method.equals("getSlNo")) {
			// HttpSession session=request.getSession();
			HashMap HashObjSlNo = (HashMap) session.getAttribute("HashObjSlNo");
			response.setContentType("application/json");
			response.setHeader("cache-control", "no-cache");
			PrintWriter writer = response.getWriter();
			String jsonString = new ObjectMapper()
					.writeValueAsString(HashObjSlNo);
			writer.println(jsonString);
			System.out.println(jsonString);
			writer.flush();
		} else if (method.equals("getTestDAO")) {
			// HttpSession session=request.getSession();
			HashMap HashObjTestDaoData = (HashMap) session
					.getAttribute("HashObjTestDaoData");
			response.setContentType("application/json");
			response.setHeader("cache-control", "no-cache");
			PrintWriter writer = response.getWriter();
			String jsonString = new ObjectMapper()
					.writeValueAsString(HashObjTestDaoData);
			writer.println(jsonString);
			System.out.println(jsonString);
			writer.flush();
		} else if (method.equals("runQuery")) {

			System.out.println("ss");
			// HttpSession session=request.getSession();
			HashMap HashObjQuery = (HashMap) session
					.getAttribute("HashObjQuery");
			response.setContentType("application/json");
			response.setHeader("cache-control", "no-cache");
			PrintWriter writer = response.getWriter();
			String jsonString = new ObjectMapper()
					.writeValueAsString(HashObjQuery);
			writer.println(jsonString);
			System.out.println(jsonString);
			writer.flush();
		}

		if (method.equals("commit")) {
			if (result == 1) {
				response.setContentType("application/json");
				response.setHeader("cache-control", "no-cache");
				PrintWriter writer = response.getWriter();
				String jsonString = new ObjectMapper()
						.writeValueAsString("SUCCESS");
				writer.println(jsonString);
				System.out.println(jsonString);
				writer.flush();
				return mapping.findForward("sucess");
			} else
				return mapping.findForward("failure");
		}

		return mapping.findForward("success");
	}
}