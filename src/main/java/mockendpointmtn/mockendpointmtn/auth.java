package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping(path = "/auth")
public class auth {
	//Getting aplication/json with content
	@PostMapping(value = "/v1/mo/sp/notify", produces = "application/json")
	public String subscription1(@RequestHeader(value="authorization", required=false) String authorization,
            @RequestHeader(value="cache-control", required=false) String cacheControl,
            @RequestHeader(value="content-type", required=false) String contentType,
            @RequestHeader(value="orangeapitoken", required=false) String orangeapitoken,
            @RequestHeader(value="x-orange-ise2", required=false) String xorangeise2,
            @RequestBody JsonNode keyValuePairs) {
		
		String callbackData = keyValuePairs.get("inboundSMSMessageNotification").get("callbackData").toString().replaceAll("^\"|\"$", "");
		String dateTime = keyValuePairs.get("inboundSMSMessageNotification").get("inboundSMSMessage").get("dateTime").toString().replaceAll("^\"|\"$", "");
		String destainationAddress = keyValuePairs.get("inboundSMSMessageNotification").get("inboundSMSMessage").get("destinationAddress").toString().replaceAll("^\"|\"$", "");
		String messageId = keyValuePairs.get("inboundSMSMessageNotification").get("inboundSMSMessage").get("messageId").toString().replaceAll("^\"|\"$", "");
		String message = keyValuePairs.get("inboundSMSMessageNotification").get("inboundSMSMessage").get("message").toString().replaceAll("^\"|\"$", "");
		String senderAddress = keyValuePairs.get("inboundSMSMessageNotification").get("inboundSMSMessage").get("senderAddress").toString().replaceAll("^\"|\"$", "");
		
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    
	    response="{\n" + 
	    		"  \"inboundSMSMessageNotification\": {\n" + 
	    		"    \"callbackData\": \""+callbackData+"\",\n" + 
	    		"    \"inboundSMSMessage\": {\n" + 
	    		"      \"dateTime\": \""+dateTime+"\",\n" + 
	    		"      \"destainationAddress\": \""+destainationAddress+"\",\n" + 
	    		"      \"messageId\": \""+messageId+"\",\n" + 
	    		"      \"message\": \""+message+"\",\n" + 
	    		"      \"senderAddress\": \""+senderAddress+"\"\n" + 
	    		"    }\n" + 
	    		"  }\n" + 
	    		"}";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	//Getting text/xml with content
	@PostMapping(value = "/v1/textxml1", produces = "text/xml")
	public String subscription2() {
		String response ="";
	    
	    response="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:unSubscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:unSubscribeProductRsp>\n" + 
	    		"				<result>0</result>\n" + 
	    		"				<resultDescription>Success</resultDescription>\n" + 
	    		"			</ns1:unSubscribeProductRsp>\n" + 
	    		"		</ns1:unSubscribeProductResponse>\n" + 
	    		"	</soapenv:Body>\n" + 
	    		"</soapenv:Envelope>";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting text/xml with content
	@PostMapping(value = "/v1/textxml2", produces = "text/xml")
	public String subscription3() {
		String response ="";
	    
	    response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}	
	
	//Getting text/xml with content
	@PostMapping(value = "/v1/textxml3", produces = "text/xml")
	public String subscription4() {
		String response ="";
		
		response="{\n" + 
				"    \"status\": \"OK\"\n" + 
				"}";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting aplication/json without content
	@PostMapping(value = "/v1/textxml4", produces = "text/xml")
	public ResponseEntity subscription5() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/textxml5", produces = "text/xml")
	public String subscription6() {
		String response ="";
	    
	    response="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:unSubscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:unSubscribeProductRsp>\n" + 
	    		"				<result>0</result>\n" + 
	    		"				<resultDescription>Success</resultDescription>\n" + 
	    		"			</ns1:unSubscribeProductRsp>\n" + 
	    		"		</ns1:unSubscribeProductResponse>\n" + 
	    		"	</soapenv:Body\n" + 
	    		"</soapenv:Envelope>";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting aplication/json 500 error
	@PostMapping(value = "/v1/internalServerError1", produces = "application/json")
	public ResponseEntity subscription7() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PostMapping(value = "/v1/internalServerError2", produces = "application/json")
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String subscription25() {
		String response ="";
		
		response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/internalServerError3", produces = "application/json")
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String subscription27() {
		String response ="";
		
		response="{\n" + 
				"    \"status\": \"500\"\n" + 
				"}";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting aplication/json 502 error
	@PostMapping(value = "/v1/badGateway1", produces = "application/json")
	public ResponseEntity subscription8() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping(value = "/v1/badGateway2", produces = "application/json")
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String subscription26() {
		String response ="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/badGateway3", produces = "application/json")
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String subscription28() {
		String response ="";
		
		response="{\n" + 
				"    \"status\": \"400\"\n" + 
				"}";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting aplication/json get OK
	@PostMapping(value = "/v1/applicationjson1", produces = "application/json")
	public String subscription9() {
		String response ="";
		
		response="{\n" + 
				"    \"status\": \"OK\"\n" + 
				"}";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting aplication/json OK only
	@PostMapping(value = "/v1/applicationjson2", produces = "application/json")
	public String subscription10() {
		String response ="";
		
		response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/applicationjson3", produces = "application/json")
	public ResponseEntity subscription11() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/applicationxml1", produces = "application/xml")
	public String subscription12() {
		String response ="";

		response="{\n" + 
				"    \"status\": \"OK\"\n" + 
				"}";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/applicationxml2", produces = "application/xml")
	public ResponseEntity subscription13() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/applicationxml3", produces = "application/xml")
	public String subscription14() {
		String response ="";
		
		response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/applicationxml5", produces = "application/xml")
	public String subscription29() {
		String response ="";
	    
	    response="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:unSubscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:unSubscribeProductRsp>\n" + 
	    		"				<result>0</result>\n" + 
	    		"				<resultDescription>Success</resultDescription>\n" + 
	    		"			</ns1:unSubscribeProductRsp>\n" + 
	    		"		</ns1:unSubscribeProductResponse>\n" + 
	    		"	</soapenv:Body>\n" + 
	    		"</soapenv:Envelope>";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/texthtml1", produces = "text/html")
	public String subscription15() {
		String response ="";
		
		response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/texthtml2", produces = "text/html")
	public ResponseEntity subscription16() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/texthtml3", produces = "text/html")
	public String subscription17() {
		String response ="";
		
		response="<html><body>OK</body></html>";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/texthtml4", produces = "text/html")
	public String subscription18() {
		String response ="";

		response="{\n" + 
				"    \"status\": \"OK\"\n" + 
				"}";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/imagejpeg1", produces = "image/jpeg")
	public ResponseEntity subscription19() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/imagejpeg2", produces = "image/jpeg")
	public String subscription20() {
		String response ="";
		
		response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	@PostMapping(value = "/v1/textplain1", produces = "text/plain")
	public ResponseEntity subscription21() {
		String response ="";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/textplain2", produces = "text/plain")
	public String subscription22() {
		String response ="";
		
		response="OK";
		
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return response;
		
	}
	
	//Getting text/xml with content
	@PostMapping(value = "/v1/applicationxml4", produces = "application/xml")
	public String subscription23() {
		String response ="";
	    
	    response="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:unSubscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:unSubscribeProductRsp>\n" + 
	    		"				<result>0</result>\n" + 
	    		"				<resultDescription>Success</resultDescription>\n" + 
	    		"			</ns1:unSubscribeProductRsp>\n" + 
	    		"		</ns1:unSubscribeProductResponse>\n" + 
	    		"	</soapenv:Body\n" + 
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
