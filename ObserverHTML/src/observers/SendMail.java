package observers;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import notifiers.DataChangeListener;

public class SendMail implements DataChangeListener {
	
	public void mailConnect() {
	
		String mailAdress = "leidiane.silva.vieira07@aluno.ifce.edu.br";
		String mailPass = "hpdxpvs7";
		String mailSubject = "Teste";
		String mailMessage = "Teste de envio com Java!";
		
		PrintConsole controller = new PrintConsole();
		//controller.subscribeDataChangeListener(this);
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(mailAdress, mailPass));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(mailAdress);
			email.setSubject(mailSubject);
			email.setMsg(mailMessage);
			email.addTo("marcosrodrigues123eu@gmail.com");
			email.send();
			} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDataChanged() {
		mailConnect();
		System.out.println("Conteúdo HTML foi alterado!");
		
	}
	
	
	
};

