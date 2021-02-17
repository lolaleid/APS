import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LoadPage {
	
	public void getPage(URL url, File file) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		
		String inputLine;
		
		//alterar logica para armazenar as informações em um lugar que possa ser comparado
		while ((inputLine = in.readLine()) != null) {
			//imprime página no console
			//System.out.println(inputLine);
			//Grava página no arquivo
			out.write(inputLine);
			//Chama a próxima linha do HTML
			out.newLine();
		}
		
		System.out.println("Deu Certo! " + new Date());
		in.close();
		out.flush();
		out.close();
		
		
	}
	
	public static void main(String [] args) {
		
		Timer timer = new Timer();
		final long time_refresh = (1000 * 60);
		
		File file = new File("C:\\ArquivosSalvos\\page.html");
		
		TimerTask tarefa = new TimerTask() {
			public void run() {
		
				try {
					URL url = new URL("https://ifce.edu.br");
					new LoadPage().getPage(url,file);
					
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
