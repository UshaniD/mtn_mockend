package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mobilenetworkservices")
public class GoogleAuth {
	@GetMapping(value = "/v2/plmns/{plmn}/userKey", produces = "application/json")
	public String getAuthChallenge(@RequestParam String authType, @RequestParam(value = "serviceName", required = false) String serviceName) {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
		
		if(!authType.isEmpty()) {
			response = "{\r\n" + 
					"  \"authType\": \""+authType+"\",\r\n" + 
					"  \"serviceName\": \""+serviceName+"\",\r\n" + 
					"  \"authChallenge\": \""+timestamp+"\",\r\n" + 
					"  \"sessionId\": \""+timestamp+"\"\r\n" + 
					"}";
		}else {
			response = "{\r\n" + 
					"    \"status\": 400,\r\n" + 
					"    \"error\": \"Bad Request\",\r\n" + 
					"    \"message\": \"authType is required\"\r\n" + 
					"}";
		}	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	@GetMapping(value = "/v2/plmns/{plmn}/userKey", produces = "application/json", params = "authResponse")
	public String getUserKey(@RequestParam String authType, @RequestParam(value = "serviceName", required = false) String serviceName, @RequestParam String authResponse) {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
		
		if(!authType.isEmpty() && !authResponse.isEmpty()) {
			response = "{\r\n" + 
					"  \"authType\": \""+authType+"\",\r\n" + 
					"  \"serviceName\": \""+serviceName+"\",\r\n" + 
					"  \"token\": {\r\n" + 
					"    \"userKey\": \""+timestamp+"\",\r\n" + 
					"    \"ttlSeconds\": "+timestamp+"\r\n" + 
					"  }\r\n" + 
					"}";
		}else {
			response = "{\r\n" + 
					"    \"status\": 400,\r\n" + 
					"    \"error\": \"Bad Request\",\r\n" + 
					"    \"message\": \"Required parameter missing\"\r\n" + 
					"}";
		}	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping(value = "/v2/plmns/{plmn}/userKey", produces = "application/json", params = "syncFailure")
	public String getSyncFailure(@RequestParam String authType, @RequestParam String syncFailure) {
		String response ="";
		
		if(!authType.isEmpty() && !syncFailure.isEmpty()) {
			response = "{\r\n" + 
					"    \"status\": 200,\r\n" + 
					"    \"error\": \"OK\",\r\n" + 
					"    \"message\": \"Sync failure\"\r\n" + 
					"}";
		}else {
			response = "{\r\n" + 
					"    \"status\": 400,\r\n" + 
					"    \"error\": \"Bad Request\",\r\n" + 
					"    \"message\": \"Required parameter missing\"\r\n" + 
					"}";
		}	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping(value = "/v2/plmns/{plmn}/serviceConfig", produces = "application/json")
	public String getServiceConfig(@RequestParam String userKey, @RequestParam String serviceName) {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
		
		if(!userKey.isEmpty() && !serviceName.isEmpty()) {
			response = "{\r\n" + 
					"  \"serviceName\": \""+serviceName+"\",\r\n" + 
					"  \"pnvConfig\": {\r\n" + 
					"    \"msisdn\": \""+timestamp+"\",\r\n" + 
					"    \"accountStatus\": \"test\"\r\n" + 
					"  }\r\n" + 
					"}";
		}else {
			response = "{\r\n" + 
					"    \"status\": 400,\r\n" + 
					"    \"error\": \"Bad Request\",\r\n" + 
					"    \"message\": \"Required parameter missing\"\r\n" + 
					"}";
		}	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	@PostMapping(path = "/v2/plmns/{plmn}/serviceUpdates", consumes = "application/json", produces = "application/json")
	public String giveServiceUpdate(@RequestParam String serviceUpdateId, @RequestBody Map<String,String> keyValuePairs) throws Exception {
		String serviceNameVal = keyValuePairs.get("serviceName");
		String userKeyVal = keyValuePairs.get("userKey");
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
		
		if(!serviceUpdateId.isEmpty()) {
			if(!serviceNameVal.isEmpty() && !userKeyVal.isEmpty()) {
				response = "{\r\n" + 
						"  \"serviceName\": \""+serviceNameVal+"\",\r\n" + 
						"  \"activationCode\": \""+timestamp+"\"\r\n" + 
						"}";
			}else {
				response = "{\r\n" + 
						"  \"errorCode\": 100,\r\n" + 
						"  \"errorMessage\": \"Required field is missing\"\r\n" + 
						"}";
			}
		}else {
			response = "{\r\n" + 
					"  \"errorCode\": 200,\r\n" + 
					"  \"errorMessage\": \"Service update id is missing\"\r\n" + 
					"}";
		}	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
