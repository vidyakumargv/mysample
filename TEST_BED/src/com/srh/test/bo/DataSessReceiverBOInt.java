package com.srh.test.bo;


import java.sql.*;
import javax.servlet.http.*;

public interface DataSessReceiverBOInt {
	
	public int recFrmSOExecute(Connection con, HttpSession sess, HttpServletRequest request,
		String action) throws Exception;





}
