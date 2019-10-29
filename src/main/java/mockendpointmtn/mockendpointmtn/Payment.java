package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
public class Payment {
	@PostMapping(value = "/{orangeAPIToken}/transactions/amount", produces = "application/json")
	public String getAuthChallenge(@RequestHeader(value="authorization", required=true) String authorization,
            @RequestHeader(value="cache-control", required=false) String cacheControl,
            @RequestHeader(value="content-type", required=false) String contentType,
            @RequestHeader(value="bizao-token", required=true) String bizaoToken,
            @RequestHeader(value="bizao-alias", required=false) String bizaoAlias) {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
	    
	    response="{\n" + 
	    		"    \"amountTransaction\": {\n" + 
	    		"        \"clientCorrelator\": \""+timestamp+"\",\n" + 
	    		"        \"endUserId\": \"acr:OrangeAPIToken\",\n" + 
	    		"        \"paymentAmount\": {\n" + 
	    		"            \"chargingInformation\": {\n" + 
	    		"                \"amount\": \"100\",\n" + 
	    		"                \"currency\": \"USD\",\n" + 
	    		"                \"description\": \"Alien Invaders Game\"\n" + 
	    		"            },\n" + 
	    		"            \"totalAmountCharged\": \"1010\",\n" + 
	    		"            \"chargingMetaData\": {\n" + 
	    		"                \"onBehalfOf\": \"Merchant\",\n" + 
	    		"                \"serviceId\": \"BIZAO\"\n" + 
	    		"            }\n" + 
	    		"        },\n" + 
	    		"        \"referenceCode\": \"REF-1234567\",\n" + 
	    		"        \"serverReferenceCode\": \"ABC-123\",\n" + 
	    		"        \"resourceURL\": \"https://gateway1a.mife.sla-mobile.com.my:8243/payment/v1/acr:OrangeAPIToken/transactions/amount/1565865989258PA15602879892\",\n" + 
	    		"        \"transactionOperationStatus\": \"Charged\"\n" + 
	    		"    }\n" + 
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
