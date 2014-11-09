package com.houngj.git.DiningPhilosophers;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DiningPhilosophersVisual {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DiningPhilosophersVisual window = new DiningPhilosophersVisual();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(200, 200);
		shell.setText("Dining Philosophers Application");

	}

}
