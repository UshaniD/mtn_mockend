package mockendpointmtn.mockendpointmtn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/smsmessaging")
public class SMSmessaging {
	@PostMapping(path = "/outbound/{msisdn}/requests", consumes = "application/json", produces = "application/json")
	public String giveServiceUpdate() throws Exception {
		String response ="";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    String timestamp = dateFormat.format(date);
		
		response = "{\n" + 
				"    \"outboundSMSMessageRequest\": {\n" + 
				"        \"senderAddress\": \"tel:+22557115893\",\n" + 
				"        \"senderName\": \"\",\n" + 
				"        \"address\": [\n" + 
				"            \"acr:X-Orange-ISE2\"\n" + 
				"        ],\n" + 
				"        \"serverReferenceCode\": \"OB-3003-0a50ef2d9ed441f1a43aca77db4991f3\",\n" + 
				"        \"resourceURL\": \"https://gateway1a.mife.sla-mobile.com.my:8243/smsmessaging/outbound/tel%3A%2B7555/requests/1565321249888SM16906/deliveryInfos\",\n" + 
				"        \"deliveryInfoList\": {\n" + 
				"            \"deliveryInfo\": [\n" + 
				"                {\n" + 
				"                    \"address\": \"acr:X-Orange-ISE2\",\n" + 
				"                    \"messageReferenceCode\": \"0a50ef2d9ed441f1a43aca77db4991f3-0\",\n" + 
				"                    \"deliveryStatus\": \"MessageWaiting\"\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"resourceURL\": \"https://gateway1a.mife.sla-mobile.com.my:8243/smsmessaging/outbound/tel%3A%2B7555/requests/1563452849611SM1760138731/deliveryInfos\"\n" + 
				"        },\n" + 
				"        \"receiptRequest\": {\n" + 
				"            \"callbackData\": \"some-data-useful-to-the-requester\",\n" + 
				"            \"notifyURL\": \"http://application.example.com/notifications/DeliveryInfoNotification\"\n" + 
				"        },\n" + 
				"        \"outboundSMSTextMessage\": {\n" + 
				"            \"message\": \"Test1\"\n" + 
				"        },\n" + 
				"        \"clientCorrelator\": \"sclls\"\n" + 
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
