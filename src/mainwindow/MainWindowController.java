package mainwindow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

import listeners.CounterListener;

/*
 * Erweitert das Programm um einen weiteren Button, der den Counter vom Label
 * zurücksetzt. Dabei soll strikt im MVC-Design Pattern gearbeitet werden.
 * 
 * Optional: Tobt euch aus. 
 * 
 * */

public class MainWindowController implements PropertyChangeListener {
	private MainWindowModel model;
	private MainWindowView view;
	private CounterListener counterListener;
	
	public MainWindowModel getModel() {	return model; }
	public void setModel(MainWindowModel model) { this.model = model; }
	
	public MainWindowView getView() { return view; }
	public void setView(MainWindowView view) { this.view = view; }
	
	public CounterListener getCounterListener() { return counterListener; }
	public void setCounterListener(CounterListener counterListener) { this.counterListener = counterListener; }
	
	public MainWindowController(MainWindowModel model, MainWindowView view) {
		this.setModel(model);
		this.setView(view);
		
		this.setCounterListener(new CounterListener(this));
		this.getModel().addPropertyChangeListener(this);
		
		this.getView().getBtnIncreaseCounter().setActionCommand("increase");
		this.getView().getBtnIncreaseCounter().addActionListener(this.getCounterListener());
		
		this.getView().getBtnDecreaseCounter().setActionCommand("decrease");
		this.getView().getBtnDecreaseCounter().addActionListener(this.getCounterListener());
		
		this.getView().getBtnResetCounter().setActionCommand("reset");
		this.getView().getBtnResetCounter().addActionListener(this.getCounterListener());
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("increase") || 
		   evt.getPropertyName().equals("decrease") || 
		   evt.getPropertyName().equals("reset")){
			this.getView().getLbCounter().setText(
				evt.getPropertyName().substring(0,1) + " " + String.valueOf(evt.getNewValue())
			);
		}
	}
}
