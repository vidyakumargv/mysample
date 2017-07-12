package  com.srh.test.bo;


import java.sql.*;
import javax.servlet.http.*;

public interface DataBeanDispatchBOInt {
	
	public int dispFrmBOExecute(Connection con, HttpSession sess, HttpServletRequest request,
		String action) throws Exception;





}
