import java.io.File;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class testmail {

	public static void SendMAil(String path,String Description, String nameto, String mailto, String subjectset, String setmsg) throws EmailException {
		
		 // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath(path);
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of John");
		  attachment.setName("Test Email");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
			 email.setSmtpPort(465);
			 email.setSSLOnConnect(true);
			 email.setAuthenticator(new DefaultAuthenticator("dummyselenium1995@gmail.com","Jyoti1995"));
			 
		  email.addTo(mailto,nameto);
		  email.setFrom("dummyselenium1995@gmail.com", "Me");
		  email.setSubject(subjectset);
		  email.setMsg(setmsg);

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}

}
