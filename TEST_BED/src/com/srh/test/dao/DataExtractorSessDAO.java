package  com.srh.test.dao;
import java.sql.*;
import java.util.*;

import javax.servlet.http.*;
import javax.sql.DataSource;

import com.srh.test.dao.interf.DataSessExtractionDAOInt;

public class DataExtractorSessDAO implements DataSessExtractionDAOInt {
    Connection con;
    HttpSession sess;
    HttpServletRequest request;
    String sel;
    String frm;
    String whr;
    String orderBy;
    String query;
    String hobjName;

   public DataExtractorSessDAO(HttpServletRequest request, 
		String query, String hobjName){

        this.request=request;
        this.query=query;
        this.hobjName=hobjName;
    }

    DataExtractorSessDAO(HttpServletRequest request, 
		String IV1,String IV2,String IV3,String IV4, String hobjName){

        this.request=request;
        sel=IV1;
        frm=IV2;
        whr=IV3;
        orderBy=IV4;
    }
    @Override
    public int selectIntoSessObj(Connection con, HttpSession sess,
			HttpServletRequest request, String query) {
        int result = 0;
        HashMap hashObj = new HashMap();
        DataSource ds;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        int count = 1;
        String increase;

        try {
         //   ds=getDataSource(request, "dbSourceKey");
            
            if(query != null && !query.isEmpty()){
            	pstat = con.prepareStatement(query);
            	System.out.println("QUERY:"+query);
            	//String selectProperties=query.substring(query.indexOf("))
            	
            }
            else
            {
                query= query.concat(" select ");
                query= query.concat(sel);
                query= query.concat(" from ");
                query= query.concat(frm);
                query= query.concat(" where ");
                query= query.concat(whr);
                query= query.concat(" order By ");
                query= query.concat(orderBy);
                pstat = con.prepareStatement(query);
            }
            rs = pstat.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsCount = rsmd.getColumnCount();
            HashMap arr_list_Parent = new HashMap();
            List arr_list_top = new ArrayList();
            while (rs.next()) {
            	   
                ArrayList arr_list = new ArrayList();
                increase = count + "";
                arr_list.add(count+"");
                for (int i = 1;i <= columnsCount;i++) 
				{
                	
                    arr_list.add(rs.getString(i));
                   
                }
                ++count;
                arr_list_top.add(arr_list);
               
                result = 1;
            }
            result=1;
            arr_list_Parent.put("listrow",arr_list_top);
            hashObj.put("result",arr_list_Parent);
            sess.setAttribute(hobjName, hashObj);
        }
        catch (Exception e) {
        	result=0;
            System.out.println("Problem in querying  database table: " + e);
        }
        finally {
            try {
                if (rs != null)
                rs.close();
                if (pstat != null)
                pstat.close();
            }
            catch (Exception ex) {
                System.out.println("Problem in closing ResultSet and Statement " + ex);
            }
        }
		return result;
        
    }

	
}