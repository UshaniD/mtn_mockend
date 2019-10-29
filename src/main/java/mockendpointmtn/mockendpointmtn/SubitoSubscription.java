package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/osubscription")
public class SubitoSubscription {
	@PostMapping(value = "/v1", produces = "text/xml")
	public String subscription(@RequestHeader(value = "RESOURCE", required = false) String resource) {
		String response1 ="";
		String response2 ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response1="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:subscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:subscribeProductRsp>\n" + 
	    		"				<result>0</result>\n" + 
	    		"				<resultDescription>successful</resultDescription>\n" + 
	    		"			</ns1:subscribeProductRsp>\n" + 
	    		"		</ns1:subscribeProductResponse>\n" + 
	    		"	</soapenv:Body>\n" + 
	    		"</soapenv:Envelope>";
	    
	    response2="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:unSubscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:unSubscribeProductRsp>\n" + 
	    		"				<result>00000000</result>\n" + 
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
		
		if (resource == null) {
			return response1;
		} else if (resource.equals("/")) {
			return response1;
		} else{
			return response2;
		}
		
	}
	
	/*@PostMapping(value = "/v1/{subscriptionID}")
	public String getSubscriptionStatus(@RequestParam(value = "extended", required = false) String extended) {
		String response1 ="";
		String response2 = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response1="{\n" + 
	    		"  \"id\": \""+timestamp2+"\",\n" + 
	    		"  \"state\": \"Completed\",\n" + 
	    		"  \"orderDate\": \""+timestamp+"\",\n" + 
	    		"  \"relatedPublicKey\": {\n" + 
	    		"    \"id\": \"OCI_test_bizao_811f1e771da21c9c391730522d1bfdc4d8cbac5781a8d4182456904d3c393f86b52567fcf05ab581f4a789cab668ee8c4512\",\n" + 
	    		"    \"name\": \"A_T\"\n" + 
	    		"  },\n" + 
	    		"  \"relatedParty\": [\n" + 
	    		"    {\n" + 
	    		"      \"id\": \"BIZAO\",\n" + 
	    		"      \"name\": \"BIZAO\",\n" + 
	    		"      \"role\": \"partner\"\n" + 
	    		"    },\n" + 
	    		"    {\n" + 
	    		"      \"id\": \"test_bizao\",\n" + 
	    		"      \"name\": \"nom_service_bizao\",\n" + 
	    		"      \"role\": \"retailer\"\n" + 
	    		"    }\n" + 
	    		"  ],\n" + 
	    		"  \"orderItem\": {\n" + 
	    		"    \"action\": \"add\",\n" + 
	    		"    \"state\": \"Completed\",\n" + 
	    		"    \"product\": {\n" + 
	    		"      \"id\": \"Service fake pour besoin test integration Bizao sub 1week\",\n" + 
	    		"      \"href\": \"na\",\n" + 
	    		"      \"productCharacteristic\": [\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"amount\",\n" + 
	    		"          \"value\": \"0.01\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"taxAmount\",\n" + 
	    		"          \"value\": \"0.0\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"currency\",\n" + 
	    		"          \"value\": \"XOF\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"periodicity\",\n" + 
	    		"          \"value\": \"86400\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"startDate\",\n" + 
	    		"          \"value\": \"2019-07-23\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"language\",\n" + 
	    		"          \"value\": \"fr\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"country\",\n" + 
	    		"          \"value\": \"CIV\"\n" + 
	    		"        }\n" + 
	    		"      ]\n" + 
	    		"    }\n" + 
	    		"  }\n" + 
	    		"}";
	    
	    response2="{\n" + 
	    		"  \"id\": \""+timestamp2+"\",\n" + 
	    		"  \"state\": \"Completed\",\n" + 
	    		"  \"orderDate\": \""+timestamp+"\",\n" + 
	    		"  \"relatedPublicKey\": {\n" + 
	    		"    \"id\": \"OCI_test_bizao_811f1e771da21c9c391730522d1bfdc4d8cbac5781a8d4182456904d3c393f86b52567fcf05ab581f4a789cab668ee8c4512\",\n" + 
	    		"    \"name\": \"A_T\"\n" + 
	    		"  },\n" + 
	    		"  \"relatedParty\": [\n" + 
	    		"    {\n" + 
	    		"      \"id\": \"BIZAO\",\n" + 
	    		"      \"name\": \"BIZAO\",\n" + 
	    		"      \"role\": \"partner\"\n" + 
	    		"    },\n" + 
	    		"    {\n" + 
	    		"      \"id\": \"test_bizao\",\n" + 
	    		"      \"name\": \"nom_service_bizao\",\n" + 
	    		"      \"role\": \"retailer\"\n" + 
	    		"    }\n" + 
	    		"  ],\n" + 
	    		"  \"orderItem\": {\n" + 
	    		"    \"action\": \"add\",\n" + 
	    		"    \"state\": \"Completed\",\n" + 
	    		"    \"product\": {\n" + 
	    		"      \"id\": \"Service fake pour besoin test integration Bizao sub 1week\",\n" + 
	    		"      \"href\": \"na\",\n" + 
	    		"      \"productCharacteristic\": [\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"amount\",\n" + 
	    		"          \"value\": \"0.01\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"taxAmount\",\n" + 
	    		"          \"value\": \"0.0\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"currency\",\n" + 
	    		"          \"value\": \"XOF\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"periodicity\",\n" + 
	    		"          \"value\": \"86400\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"startDate\",\n" + 
	    		"          \"value\": \"2019-07-23\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"language\",\n" + 
	    		"          \"value\": \"fr\"\n" + 
	    		"        },\n" + 
	    		"        {\n" + 
	    		"          \"name\": \"country\",\n" + 
	    		"          \"value\": \"CIV\"\n" + 
	    		"        }\n" + 
	    		"      ]\n" + 
	    		"    }\n" + 
	    		"  },\n" + 
	    		"  \"events\": [\n" + 
	    		"    {\n" + 
	    		"      \"date\": \"2019-07-23T10:37:19.190Z\",\n" + 
	    		"      \"type\": \"PERIODIC-CHARGE\",\n" + 
	    		"      \"chargedAmount\": 0.01,\n" + 
	    		"      \"status\": \"SUCCESS\"\n" + 
	    		"    },\n" + 
	    		"    {\n" + 
	    		"      \"date\": \"2019-07-23T10:37:22.220Z\",\n" + 
	    		"      \"type\": \"CREATION\",\n" + 
	    		"      \"status\": \"SUCCESS\"\n" + 
	    		"    },\n" + 
	    		"    {\n" + 
	    		"      \"date\": \"2019-07-24T10:40:00.000Z\",\n" + 
	    		"      \"type\": \"ARCHIVING\",\n" + 
	    		"      \"status\": \"SUCCESS\"\n" + 
	    		"    }\n" + 
	    		"  ]\n" + 
	    		"}";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (extended == null) {
			return response1;
		} else if (extended.equals("true")) {
			return response2;
		} else{
			return response1;
		}
		
	}*/
	
	/*@DeleteMapping(value = "/v1", produces = "text/xml")
	public String unsubscribe() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="<soapenv:Envelope\n" + 
	    		"	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
	    		"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
	    		"	<soapenv:Body>\n" + 
	    		"		<ns1:unSubscribeProductResponse\n" + 
	    		"			xmlns:ns1=\"http://www.csapi.org/schema/parlayx/subscribe/manage/v1_0/local\">\n" + 
	    		"			<ns1:unSubscribeProductRsp>\n" + 
	    		"				<result>00000000</result>\n" + 
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
		
	}*/
	
	@PostMapping(value = "/v1/renew", produces = "application/json")
	public ResponseEntity subscriptionNotification() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="<syncOrderRelationResponse xmlns=\"http://ws.apache.org/ns/synapse\">\n" + 
	    		"    <result>000000000000000000000000000000000000000000000000000000000000000000000000000</result>\n" + 
	    		"    <resultDescription>OK</resultDescription>\n" + 
	    		"</syncOrderRelationResponse>";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*String[] status = {"SUCCESS","ERROR","SUCCESS","ERROR","ERROR"};
        int idx = new Random().nextInt(status.length);
        String tmpStatus = (status[idx]);
        //System.err.println(tmpStatus+"----------------------------------------------");
        
        if(tmpStatus.equals("SUCCESS")) {
        	return new ResponseEntity(HttpStatus.OK);
        }
        else {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
        
       //return response;
		return new ResponseEntity(HttpStatus.OK);
        
		
	}

}
