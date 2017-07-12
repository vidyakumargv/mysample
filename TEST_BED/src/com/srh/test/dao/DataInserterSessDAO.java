package com.srh.test.dao;
import java.sql.*;
import java.util.*;

import javax.servlet.http.*;
import javax.sql.DataSource;

import com.srh.test.dao.interf.DataSessInsertionDAOInt;

public class DataInserterSessDAO implements DataSessInsertionDAOInt {
    Connection con;
    HttpSession sess;
    HttpServletRequest request;
    String insert;
    String into;
    String whr;
    String query;
    ArrayList<String> queryArray;
    String values;
    HashMap HashObjValues;
    
    public DataInserterSessDAO(HttpServletRequest request, 
    		String query){

            this.request=request;
            this.query=query;
        }
    
    public DataInserterSessDAO(HttpServletRequest request, 
    		 ArrayList<String> queryArray){

            this.request=request;
            this.queryArray=queryArray;
        }
    
    DataInserterSessDAO(HttpServletRequest request, 
		String query, String hobjName){

        this.request=request;
        this.query=query;
    }

    DataInserterSessDAO(HttpServletRequest request, 
		String IV1,String IV2,String IV3){

        this.request=request;
        insert=IV1;
        into=IV2;
        values=IV3;
    }

    DataInserterSessDAO(HttpServletRequest request, 
		String IV1,String IV2,HashMap HashObj){

        this.request=request;
        insert=IV1;
        into=IV2;
        HashObjValues=HashObj;
    }

   /* public HashMap insert() {
        int result = 0;
        HashMap hashObj = new HashMap();
        DataSource ds;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        int count = 1;
        String increase;

        try {
            if(query) 
            pstat = con.prepareStatement(query); //First construtor used
            else
            {
				if(values) //Second construtor used
				{
                query= query.concat(" Insert ");
                query= query.concat(insert);
                query= query.concat(" Into ");
                query= query.concat(into);
                query= query.concat(" Values ");
                query= query.concat(values);
                pstat = con.prepareStatement(query);
				}
				else //Third construtor used
				{
					//open the hash object
					//assign the values 
					//run the query 
					 pstat = con.prepareStatement(query);
				}

            }
           pstat.executeQuery();
            

        }catch (Exception e) {
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
    }
*/
	@Override
	public int insertFrmSessObj(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {

        int result = 0;
        HashMap hashObj = new HashMap();
        DataSource ds;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        int count = 1;
        String increase;

        try {

            if(query != null && !query.isEmpty() ) 
            pstat = con.prepareStatement(query); //First construtor used
            else
            {
				if(values != null && !values.isEmpty()) //Second construtor used
				{
                query= query.concat(" Insert ");
                query= query.concat(insert);
                query= query.concat(" Into ");
                query= query.concat(into);
                query= query.concat(" Values ");
                query= query.concat(values);
                pstat = con.prepareStatement(query);
				}
				else //Third construtor used
				{
					//open the hash object
					//assign the values 
					//run the query 
					 pstat = con.prepareStatement(query);
				}

            }
           pstat.executeUpdate();
           result=1;

        }catch (Exception e) {
            System.out.println("Problem in querying  database table: " + e);
            result=0;
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

	@Override
	public int insertFrmSessObjArray(Connection con, HttpSession sess,
			HttpServletRequest request, String action) throws Exception {
		


        int result = 0;
        HashMap hashObj = new HashMap();
        DataSource ds;
        PreparedStatement pstat = null;
        Statement stmt=null;
        ResultSet rs = null;
        int count = 1;
        String increase;

        try {

            if(queryArray != null && !(queryArray.isEmpty())) {
         
            	stmt = con.createStatement();
            for (String query : queryArray) {
            	stmt.addBatch(query);
            }
            stmt.executeBatch();
            stmt.close();
           // stmt.close();
            	
            	 //First construtor used
        }else
            {
				if(values != null && !values.isEmpty()) //Second construtor used
				{
                query= query.concat(" Insert ");
                query= query.concat(insert);
                query= query.concat(" Into ");
                query= query.concat(into);
                query= query.concat(" Values ");
                query= query.concat(values);
                pstat = con.prepareStatement(query);
				}
				else //Third construtor used
				{
					//open the hash object
					//assign the values 
					//run the query 
					 pstat = con.prepareStatement(query);
				}
				  pstat.executeUpdate();
            }
         
           result=1;

        }catch (Exception e) {
            System.out.println("Problem in querying  database table: " + e);
            result=0;
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