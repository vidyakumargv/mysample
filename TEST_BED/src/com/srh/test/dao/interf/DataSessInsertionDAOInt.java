package com.srh.test.dao.interf;

import java.sql.*;
import javax.servlet.http.*;

public interface DataSessInsertionDAOInt   {
	
	public int insertFrmSessObj(Connection con, HttpSession sess, HttpServletRequest request,
		String action) throws Exception;

	public int insertFrmSessObjArray(Connection con, HttpSession sess, HttpServletRequest request,
			String action) throws Exception;





}
