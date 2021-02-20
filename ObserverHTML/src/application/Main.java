package application;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import notifiers.LoadPage;
import observers.PrintConsole;

public class Main {

	public static void main(String[] args) {
		
		//SendMail sendmail = new SendMail();
		//String mailTo = "marcosrodrigues123eu@gmail.com";
		
		Timer timer = new Timer();
		final long time_refresh = (1000 * 60);
		
		File file = new File("C:\\ArquivosSalvos\\page.html");
		LoadPage load = new LoadPage();
		PrintConsole prt = new PrintConsole();
		
		TimerTask tarefa = new TimerTask() {
			public void run() {
		
				try {
					URL url = new URL("https://ifce.edu.br");
					prt.subscribeMe();
					load.getPage(url,file);
					
					//sendmail.mailConnect(mailTo);
					
				}catch(MalformedURLException e){
					e.printStackTrace();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
		
			}
		};
		
		timer.scheduleAtFixedRate(tarefa, 0, time_refresh);
		
	}

}
