package guidemo;

import mainwindow.MainWindowController;
import mainwindow.MainWindowModel;
import mainwindow.MainWindowView;

public class GuiDemo {
	public static void main(String[] args) {
		new MainWindowController(new MainWindowModel(), new MainWindowView());
	}
}
