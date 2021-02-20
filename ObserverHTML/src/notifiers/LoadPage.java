package notifiers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import observers.PrintConsole;

public class LoadPage {
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	public void getPage(URL url, File file) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
				
			//System.out.println(inputLine);
			//Grava página no arquivo
			out.write(inputLine);
			//Chama a próxima linha
			out.newLine();
			
		}
		
		notifyDataChangeListeners();
		
		//System.out.println("Deu Certo! " + new Date());
		in.close();
		out.flush();
		out.close();
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	public void notifyDataChangeListeners() {
		PrintConsole prt = new PrintConsole();
		prt.onDataChanged();
		
	}
	
}
