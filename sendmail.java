package project;

import java.io.IOException;
import java.net.MalformedURLException;

import com.sendgrid.*;

public class sendmail {
	sendmail(String Email,String OTP) throws IOException,MalformedURLException{
		//System.out.println(Email+" "+OTP);
		Email from = new Email("18eucs112@skcet.ac.in");
	    String subject = "College Complain Management System";
	    Email to = new Email(Email);
	    Content content = new Content("text/plain", "YOUR OTP: "+OTP);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      
	    } catch (IOException ex) {
	      System.out.println(ex);
	    }
	}
}
