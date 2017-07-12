package com.srh.test.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface DataInsertSessBO {
	public int insertFrmSessObj(Connection con, HttpSession sess, HttpServletRequest request,
			String action) throws Exception;


}
