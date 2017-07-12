package com.srh.test.bo;



import java.sql.*;
import javax.servlet.http.*;

public interface DataBeanReceiverBOInt {
	
	public int recFrmBOExecute(Connection con, HttpSession sess, HttpServletRequest request,
		String action) throws Exception;





}
