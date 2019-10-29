package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/SubscribeManageService")
public class Subscription_MNT {
	@PostMapping(value = "/services/SubscribeManage", produces = "application/json")
	public String subscription() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="<soapenv:Envelope\n" + 
	    		"    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"    <soapenv:Body>\n" + 
	    		"        <ns1:subscribeProductResponse\n" + 
	    		"            xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"            <ns1:subscribeProductRsp>\n" + 
	    		"                <result>0</result> \n" + 
	    		"                <resultDescription>successful</resultDescription>\n" + 
	    		"            </ns1:subscribeProductRsp>\n" + 
	    		"        </ns1:subscribeProductResponse>\n" + 
	    		"    </soapenv:Body>\n" + 
	    		"</soapenv:Envelope>";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}

}
