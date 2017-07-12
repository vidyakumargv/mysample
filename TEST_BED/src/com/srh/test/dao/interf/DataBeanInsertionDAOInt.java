package com.srh.test.dao.interf;

import java.sql.*;
import javax.servlet.http.*;

public interface DataBeanInsertionDAOInt {
	
	public int insertFrmBeanObj(Connection con, HttpSession sess, HttpServletRequest request,
		String action) throws Exception;





}
