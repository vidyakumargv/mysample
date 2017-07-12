package com.srh.test.bo;



import java.sql.*;
import javax.servlet.http.*;

public interface DataSessDispatchBOInt {

	public int dispFrmSOExecute(Connection con, HttpSession sess, HttpServletRequest request,
		String action) throws Exception;





}
