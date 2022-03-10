package mainwindow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainWindowModel {
	private int counter;
	private PropertyChangeSupport propertyChangeSupport;

	public int getCounter() { return counter; }
	public void setCounter(int counter) { this.counter = counter; }
	
	public PropertyChangeSupport getPropertyChangeSupport() { return propertyChangeSupport; }
	public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {	this.propertyChangeSupport = propertyChangeSupport;	}
	
	public MainWindowModel() {
		this(0);
	}
	
	public MainWindowModel(int counter) {
		this.setCounter(counter);
		this.setPropertyChangeSupport(new PropertyChangeSupport(this));
	}
	
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        this.getPropertyChangeSupport().addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
    	 this.getPropertyChangeSupport().removePropertyChangeListener(pcl);
    }
	
	public void increase() {
		int newValue = this.getCounter() + 1;
		this.getPropertyChangeSupport().firePropertyChange("increase", this.getCounter(), newValue);
		this.setCounter(newValue);
	}
	
	public void decrease() {
		int newValue = this.getCounter() - 1;
		this.getPropertyChangeSupport().firePropertyChange("decrease", this.getCounter(), newValue);
		this.setCounter(newValue);
	}
	
	public void reset() {
		int newValue = 0;
		this.getPropertyChangeSupport().firePropertyChange("reset", this.getCounter(), newValue);
		this.setCounter(newValue);
	}
}
