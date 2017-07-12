package com.srh.test.bo;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srh.test.action.DataExtractorSessBO;
import com.srh.test.dao.DataExtractorSessDAO;

public class GetSLNoDataExtractorSessBO implements DataExtractorSessBO {
	
    public int executeAndDispToSO(HttpServletRequest request) throws Exception {

      
		HttpSession session = request.getSession();
			
					String clId=(String) request.getParameter("clId");
					String smId=(String) request.getParameter("smId");
							
							String query1 ="select sLNo from tt_testdaoblgsp where clId="+clId+" and "+"smId="+smId;
                            DataExtractorSessDAO dao = new DataExtractorSessDAO(request, query1,"HashObjSlNo");
							dao.selectIntoSessObj(null, session, request, query1);

							
							HashMap HashObjSlNo = (HashMap) session.getAttribute("HashObjSlNo");
							//convert HashObjSlNo into json object

							/*
							response.setContentType("application/json");
							response.setHeader("cache-control", "no-cache");
							PrintWriter writer = response.getWriter();
							writer.println(jsonString);
							writer.flush();
							*/

                            return 1;
    }

	@Override
	public int executeAndDispToSO(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String clId=(String) request.getParameter("clId");
		String smId=(String) request.getParameter("smId");

				
				String query1 ="select slNo from tt_testdaoblgsp where clId='"+clId+"' and "+"reqtId='"+smId+"'";
                DataExtractorSessDAO dao = new DataExtractorSessDAO(request, query1,"HashObjSlNo");
				dao.selectIntoSessObj(con, session, request, query1);

				
				HashMap HashObjSlNo = (HashMap) session.getAttribute("HashObjSlNo");
				//convert HashObjSlNo into json object

				/*
				response.setContentType("application/json");
				response.setHeader("cache-control", "no-cache");
				PrintWriter writer = response.getWriter();
				writer.println(jsonString);
				writer.flush();
				*/

                return 1;
	}

	
}