package com.houngj.git.DiningPhilosophers;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;

public class DiningPhilosophersVisual {

	protected Shell shlDiningPhilosophers;
	private Text text;
	private Text text_1;

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
		while (!shlDiningPhilosophers.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDiningPhilosophers = new Shell();
		shlDiningPhilosophers.setText("Dining Philosophers");
		shlDiningPhilosophers.setSize(369, 267);
		
		text = new Text(shlDiningPhilosophers, SWT.BORDER);
		text.setBounds(49, 7, 64, 19);
		
		Label lblNum = new Label(shlDiningPhilosophers, SWT.NONE);
		lblNum.setBounds(10, 10, 59, 14);
		lblNum.setText("Num");
		
		Button btnRun = new Button(shlDiningPhilosophers, SWT.NONE);
		btnRun.setBounds(154, 0, 94, 28);
		btnRun.setText("Run");
		
		text_1 = new Text(shlDiningPhilosophers, SWT.BORDER);
		text_1.setBounds(10, 32, 94, 70);
		  
		btnRun.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		          switch (e.type) {
		          case SWT.Selection:
		        	  try{
		        		  text_1.setText("Hello");
		        		  shlDiningPhilosophers.update();
		        		  DiningPhilosophers d = new DiningPhilosophers(Integer.parseInt(text.getText()), shlDiningPhilosophers, text_1);
		        		  d.startEating();
		        	  }catch(InterruptedException error){
		      		}
		        	  break;
		          }
		        }
		      });
		shlDiningPhilosophers.open();
	}
	
}
