package com.srh.test.dao.interf;

import java.sql.*;
import javax.servlet.http.*;

public interface DataSessExtractionDAOInt {

		public int selectIntoSessObj(Connection con, HttpSession sess, HttpServletRequest request,
			String action) throws Exception;





}
