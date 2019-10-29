package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/eligibility")
public class Eligibility {
	@GetMapping(value = "/{orangeAPIToken}/infos", produces = "application/json")
	public String getAuthChallenge(@RequestParam(value = "configuration", required = true) String configuration, 
			@RequestParam(value = "country", required = true) String country,
			@RequestHeader(value="authorization", required=true) String authorization,
            @RequestHeader(value="cache-control", required=false) String cacheControl,
            @RequestHeader(value="content-type", required=false) String contentType,
            @RequestHeader(value="bizao-token", required=true) String bizaoToken,
            @RequestHeader(value="bizao-alias", required=false) String bizaoAlias,
            @RequestHeader(value="orangeapitoken", required=false) String orangeapitoken,
            @RequestHeader(value="x-orange-ise2", required=false) String xOrangeIse2) {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
		
		response = "{\n" + 
				"  \"configuration\": \""+configuration+"\",\n" + 
				"  \"country\": \""+country+"\",\n" + 
				"  \"accountId\": \"acr:OrangeAPIToken\",\n" + 
				"  \"infos\": [\n" + 
				"    {\n" + 
				"      \"key\": \"user_type\",\n" + 
				"      \"value\": \"Postpaid\"\n" + 
				"    }\n" + 
				"  ]\n" + 
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
