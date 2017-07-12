package com.srh.test.bo;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srh.test.action.DataExtractorSessBO;
import com.srh.test.dao.DataExtractorSessDAO;

public class RunQueryDataExtractorSessBO implements DataExtractorSessBO {

	@Override
	public int executeAndDispToSO(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {


	      
		HttpSession session = request.getSession();
		String idQuery=request.getParameter("runQueryParam");
		
		String quries[]=idQuery.split("-");
		
		DataExtractorSessDAO dao = new DataExtractorSessDAO(request, quries[1],"HashObjQuery");
		int result=dao.selectIntoSessObj(con, session, request, quries[1]);
		
      return result;
    
	}

	
}