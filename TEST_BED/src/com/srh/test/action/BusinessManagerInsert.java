package  com.srh.test.action;
import com.srh.test.bo.DataSessDispatchBOInt;
import com.srh.test.bo.GetClIdDataExtractorSessBO;
import com.srh.test.bo.GetSLNoDataExtractorSessBO;
import com.srh.test.bo.GetSmIdDataExtractorSessBO;
import com.srh.test.bo.GetTestDAODataExtractorSessBO;
//import com.srh.test.bo.RunQueryDataExtractorSessBO;
import com.srh.test.bo.RunQueryDataExtractorSessBO;
import com.srh.test.bo.TestDataInserterSessBO;


public class BusinessManagerInsert 
	{
	
	
    public static DataInsertSessBO getBusinessObject(String method) 
		throws Exception {

    	
    	DataInsertSessBO bo = null;
    	
    	
		switch(method)
		{
			
			case "commit":bo = new TestDataInserterSessBO();
			break;
        }

        return bo;
    }
    
	}