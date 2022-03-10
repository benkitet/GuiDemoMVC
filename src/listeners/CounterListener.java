package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import mainwindow.MainWindowController;

public class CounterListener implements ActionListener {

	private MainWindowController controller;
	
	public CounterListener(MainWindowController controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "increase": {
				controller.getModel().increase();
				
				
				break;
			}
			case "decrease": {
				controller.getModel().decrease();
				break;
			}
			case "reset": {
				controller.getModel().reset();
				break;
			}
			default: {
				throw new RuntimeException("ActionCommand unknown");
			}
		}
	}

}
