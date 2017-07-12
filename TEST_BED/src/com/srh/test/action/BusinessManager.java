package  com.srh.test.action;
import com.srh.test.bo.GetClIdDataExtractorSessBO;
import com.srh.test.bo.GetSLNoDataExtractorSessBO;
import com.srh.test.bo.GetSmIdDataExtractorSessBO;
import com.srh.test.bo.GetTestDAODataExtractorSessBO;
//import com.srh.test.bo.RunQueryDataExtractorSessBO;
import com.srh.test.bo.RunQueryDataExtractorSessBO;


public class BusinessManager 
	{
	
	
    public static DataExtractorSessBO getBusinessObject(String method) 
		throws Exception {

    	
    	DataExtractorSessBO bo = null;
    	
    	
		switch(method)
		{
			case "getClId":bo = new GetClIdDataExtractorSessBO();
			break;
			case "getSmId":bo = new GetSmIdDataExtractorSessBO();
			break;
			case "getSlNo":bo = new GetSLNoDataExtractorSessBO();
			break;
			case "getTestDAO":bo = new GetTestDAODataExtractorSessBO();
			break;
      		case "runQuery":bo = new RunQueryDataExtractorSessBO();
			break;
		//	case "compareWithDb":bo = new CompareWithDbDataExtractorSessBO();
			//break;
			//case "commit":	DataSessRecieveBOInt bo;
			//				bo = new TestDataInserterSessBO();
			//sbreak;
        }

        return bo;
    }
    
	}