package com.srh.test.bo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srh.test.action.DataInsertSessBO;
import com.srh.test.dao.DataExtractorSessDAO;
import com.srh.test.dao.DataInserterSessDAO;

public class TestDataInserterSessBO implements DataInsertSessBO {
	public int executeAndInsertToSO(HttpServletRequest request)
			throws Exception {

		HttpSession session = request.getSession();

		// String HashObjTestDaoData=session.getattribute("HashObjTestDaoData");

		// 1. convert the Hash object to suitable array list or any other
		// format.
		// 2. construct a data inserter
		// 3. formulate the query with values (inside the loop)
		// 4. insert the upadted query into the table tt_testDAO
		// 5. inset the session result object into tt_testDAOSession bean object
		// into tt_testDAOBean

		return 1;
	}

	@Override
	public int insertFrmSessObj(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {

		HttpSession session = request.getSession();
		String idQuery = request.getParameter("runQueryParam");

		String quries[] = idQuery.split("-");

		String query = "UPDATE tt_testdao SET perfectQueryAFTest='" + quries[1]
				+ "',Remarks='Y'  WHERE fnPtr='" + quries[0].trim() + "'";

		DataInserterSessDAO dao = new DataInserterSessDAO(request, query);
		int result = dao.insertFrmSessObj(con, session, request, "commit");
		
		String query1 = "select reqtId, condId, fnPtr, fnId, fnOutput from testbed.tt_testdaoblgsp where fnPtr='" + quries[0].trim() + "'";
		
		DataExtractorSessDAO dao1 = new DataExtractorSessDAO(request, query1,"HashColumnInfo");
		dao1.selectIntoSessObj(con, sess, request, query1);
		

		HashMap hashColumnInfo = (HashMap) session
				.getAttribute("HashColumnInfo");
		
		if (result > 0) {
			String selectProperties = quries[1].substring(6, (quries[1]
					.indexOf("FROM") > 0 ? quries[1].indexOf("FROM")
					: quries[1].indexOf("from")));

			String[] selectPropertiesValues = selectProperties.trim()
					.split(",");
			int colCount=1;
			ArrayList<String> queryArray=new ArrayList<String>();
			for (String col : selectPropertiesValues) {

				HashMap HashObjQuery = (HashMap) session
						.getAttribute("HashObjQuery");

				ArrayList<ArrayList> al = (ArrayList<ArrayList>) ((HashMap) HashObjQuery
						.get("result")).get("listrow");

				ArrayList<ArrayList> listHashColumnInfo = (ArrayList<ArrayList>) ((HashMap) hashColumnInfo
						.get("result")).get("listrow");
				
				for (ArrayList<ArrayList> a : al) {
					//for (Object b : a) {
					String queryS = "insert into tt_testdaobean (reqtId,condId,fnPtr,fnId,fnObjName,fnObjDT,VNDT,VN,VNValue) values('"
							+ listHashColumnInfo.get(0).get(1)
							+ "','"
							+ listHashColumnInfo.get(0).get(2)
							+ "','"
							+ listHashColumnInfo.get(0).get(3)
							+ "','"
							+ listHashColumnInfo.get(0).get(4)
							+ "','"
							+ listHashColumnInfo.get(0).get(4)
							+ "','"
							+ listHashColumnInfo.get(0).get(5)
							+ "','"
							+ "String"
							+ "','"
							+ col
							+ "','" + a.get(colCount) + "')";
					System.out.println("sss" + queryS);
						
						queryArray.add(queryS);
					//}
				}
				
				++colCount;

			}
			
			DataInserterSessDAO dao2 = new DataInserterSessDAO(request, queryArray);
			int result2 = dao2.insertFrmSessObjArray(con, session, request, "commitParams");
			
			
		}

		return result;
	}
}