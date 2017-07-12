package com.srh.test.bo;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srh.test.action.DataExtractorSessBO;
import com.srh.test.dao.DataExtractorSessDAO;

public class GetClIdDataExtractorSessBO implements DataExtractorSessBO {
	
   


	@Override
	public int executeAndDispToSO(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {


    	
		String query1 ="select distinct(clId) from tt_testdaoblgsp;";
        DataExtractorSessDAO dao = new DataExtractorSessDAO(request, query1,"HashObjClId");
		dao.selectIntoSessObj(con, sess, request, query1);
		//convert HashObjClId into json object 
        
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