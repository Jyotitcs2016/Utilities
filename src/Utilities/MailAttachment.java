package Utilities;

import java.io.File;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class MailAttachment {
	EmailAttachment attachment;
	MultiPartEmail email;
	
	
	public void setConnection(String sendto,String subjectset,String toname,String sendfrom,String fromname, String setmsg) {
		
		
		  try {
			email.addTo(sendto, toname);
			email.setFrom(sendfrom,fromname);
			  email.setSubject(subjectset);
			  email.setMsg(setmsg);
			  
		} catch (EmailException e) {
			
			e.printStackTrace();
		}
		  
	}
	public void setAttachment(String path,String description,String name) throws EmailException {
		attachment=new EmailAttachment();
		
		  attachment.setPath(path);
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);	
		  attachment.setDescription(description);
		  attachment.setName(name);
		  
	}

	public  MailAttachment() throws EmailException {
		 
		 
		 
		 email= new MultiPartEmail();
		 email.setHostName("smtp.gmail.com");
		 email.setSmtpPort(465);
		 email.setAuthenticator(new DefaultAuthenticator("dummyselenium1995@gmail.com", "Jyoti1995"));
		 email.setSSLOnConnect(true);
		 email.attach(attachment);
		 email.send();
		
	}
	
	


}
