package com.srh.test.bo;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srh.test.action.DataExtractorSessBO;
import com.srh.test.dao.DataExtractorSessDAO;

public class GetSmIdDataExtractorSessBO implements DataExtractorSessBO {
    

	@Override
	public int executeAndDispToSO(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {

						HttpSession session = request.getSession();

							String clId= request.getParameter("clId");
							
							String query1 ="select distinct(reqtId) from tt_testdaoblgsp where clId='"+clId+"'";
                            DataExtractorSessDAO dao = new DataExtractorSessDAO(request, query1,"HashObjSmId");
							dao.selectIntoSessObj(con, session, request, query1);

							HashMap HashObjSmId = (HashMap) session.getAttribute("HashObjSmId");
							//convert HashObjSmId into json object

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