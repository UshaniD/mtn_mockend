package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/omoneypay")
public class OmoneyPay {
	@PostMapping(value = "/v1", produces = "application/json")
	public String getAuthChallenge(@RequestHeader(value="authorization", required=true) String authorization,
            @RequestHeader(value="cache-control", required=false) String cacheControl,
            @RequestHeader(value="content-type", required=false) String contentType,
            @RequestHeader(value="bizao-token", required=true) String bizaoToken,
            @RequestHeader(value="bizao-alias", required=false) String bizaoAlias,
            @RequestHeader(value="accept", required=false) String accept,
            @RequestHeader(value="country-code", required=true) String countryCode,
            @RequestHeader(value="mno-name", required=true) String mnoName) {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    
	    response="{\n" + 
	    		"  \"status\": 201,\n" + 
	    		"  \"message\": \"OK\",\n" + 
	    		"  \"pay_token\": \"pay_token4073da74-3228-4950-aa13-87c160d07659"+timestamp+"\",\n" + 
	    		"  \"payment_url\": \"https://webpayment-ow-sb.orange-money.com/lo2bvjm5ydrnbsmd1atzcxfxtwwwe8d2h6qtch8ozbxsasfeawSUCCESS\",\n" + 
	    		"  \"notif_token\": \"notif_tokenb858e83d-658a-4693-9b6c-9289392ad627\"\n" + 
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
