package Utilities;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmailTest {

	public static void main(String[] args) throws EmailException {
		
		EmailAttachment attachment=new EmailAttachment();
		attachment.setPath("MailPoling/MailPoling.7z");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Test7Z file");
		  attachment.setName("Archive");
		  
		  MultiPartEmail email=new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		
			 email.setSmtpPort(465);
			 email.setSSLOnConnect(true);
			 email.setAuthenticator(new DefaultAuthenticator("dummyselenium1995@gmail.com","Jyoti1995"));
			 
		  try {
			email.addTo("jyotiprakash569@gmail.com","Jyoti");
			email.setFrom("dummyselenium1995@gmail.com", "Me");
			  email.setSubject("Test Email");
			  email.setMsg("PFA in Zip");
		} catch (EmailException e) {
			
			System.out.println(e.getMessage());
		}
		  System.out.println("Mail started sending");
		  email.attach(attachment);
		  email.send();
		  System.out.println("Mail is sent");
		
		
		
	}

}
