package com.srh.test.bo;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srh.test.action.DataExtractorSessBO;
import com.srh.test.dao.DataExtractorSessDAO;

public class GetTestDAODataExtractorSessBO implements DataExtractorSessBO {

	@Override
	public int executeAndDispToSO(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {


	      
		HttpSession session = request.getSession();

		String clId=(String) request.getParameter("clId");
		String smId=(String) request.getParameter("smId");
		String slNoFrom=(String) request.getParameter("slNoFrom");
		String slNoTo=(String) request.getParameter("slNoTo");
		String fnOutPut=(String) request.getParameter("fnOutput");
		String fnSubType=(String) request.getParameter("fnSubType");

							
							//String query1 ="select * from tt_testdaoblgsp where clId="+clId+" and smId="+smId+" and fnOutPut="+fnOutPut+",fnSubType="+fnSubType+"+slNo >=" +slNoFrom+ ",slNo <" +slNoTo ;
							String query1= "select td.slNo,td.reqtId,td.condId,td.subCondId,td.logicSlNo,td.fnId,tt.actualQueryBFTest,tt.fnDetail,tt.perfectQueryAFTest,td.fnPtr,tt.Remarks "
									+ "from tt_testdaoblgsp td JOIN tt_testdao  tt ON tt.fnPtr = td.fnPtr  "
									+ "where "+"td.clId='"+clId+"' and td.reqtId='"+smId+"' "
											+ " and td.fnOutPut='"+fnOutPut+"' and td.fnType='"+"DAO"+"'  "
													+ " and td.slNo >= "+slNoFrom+" and td.slNo <="+ slNoTo +""
															+ " and tt.fnSubType='"+fnSubType+"'";  

		
							DataExtractorSessDAO dao = new DataExtractorSessDAO(request, query1,"HashObjTestDaoData");
							dao.selectIntoSessObj(con, session, request, query1);

							
							HashMap HashObjTestDaoData = (HashMap) session.getAttribute("HashObjTestDaoData");
							//convert HashObjTestDaoData into json object

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