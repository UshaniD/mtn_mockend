package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authorization/v1")
public class SubitoToken {
	@PostMapping(value = "/notification/sp/access-token", produces = "application/json")
	public String auth() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="{\n" + 
	    		"  \"token_type\": \"Bearer\",\n" + 
	    		"  \"access_token\": \"OCI_test_bizao_d8815f2dd96fd06973f1b030968f8d11a3d72e6984f7de4355864d731398199fe6f3c063c315ea0f7d1dae466b712afd7a6a--"+timestamp+"\",\n" + 
	    		"  \"expires_in\": 3600,\n" + 
	    		"  \"scope\": \"subito\"\n" + 
	    		"}";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	@GetMapping(value = "/callback/auth-code?code={v1}&amp;state={v2}", produces = "application/json")
	public String code() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="{\n" + 
	    		"  \"token_type\": \"Bearer\",\n" + 
	    		"  \"access_token\": \"OCI_test_bizao_d8815f2dd96fd06973f1b030968f8d11a3d72e6984f7de4355864d731398199fe6f3c063c315ea0f7d1dae466b712afd7a6a--"+timestamp+"\",\n" + 
	    		"  \"expires_in\": 3600,\n" + 
	    		"  \"scope\": \"subito\"\n" + 
	    		"}";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	@GetMapping(value = "/callback/auth-code?error={v1}&amp;error_description={v2}&amp;state={v3}", produces = "application/json")
	public String error() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="{\n" + 
	    		"  \"token_type\": \"Bearer\",\n" + 
	    		"  \"access_token\": \"OCI_test_bizao_d8815f2dd96fd06973f1b030968f8d11a3d72e6984f7de4355864d731398199fe6f3c063c315ea0f7d1dae466b712afd7a6a--"+timestamp+"\",\n" + 
	    		"  \"expires_in\": 3600,\n" + 
	    		"  \"scope\": \"subito\"\n" + 
	    		"}";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	@PostMapping(value = "/callback/auth-code/request", produces = "application/json")
	public String request() {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //2019-07-23T09:46:23Z
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    String timestamp2 = dateFormat2.format(date);
	    
	    response="{\n" + 
	    		"  \"token_type\": \"Bearer\",\n" + 
	    		"  \"access_token\": \"OCI_test_bizao_d8815f2dd96fd06973f1b030968f8d11a3d72e6984f7de4355864d731398199fe6f3c063c315ea0f7d1dae466b712afd7a6a--"+timestamp+"\",\n" + 
	    		"  \"expires_in\": 3600,\n" + 
	    		"  \"scope\": \"subito\"\n" + 
	    		"}";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}

}
