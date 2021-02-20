package observers;


import notifiers.*;

public class PrintConsole implements DataChangeListener{
	
	public void subscribeMe() {
		LoadPage loads = new LoadPage();
		loads.subscribeDataChangeListener(this);
		
	}

	@Override
	public void onDataChanged() {
		System.out.println("HTML alterado!!!");
		
	}
	

}
