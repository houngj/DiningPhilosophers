package com.houngj.git.DiningPhilosophers;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DiningPhilosophers {
	
	private Object[] forks;
	private Philosopher[] philosophers;
	private Text text;
	private Shell shell;
	public DiningPhilosophers(int num, Shell shlDiningPhilosophers, Text text_1){
		this.text = text_1;
		this.shell = shlDiningPhilosophers;
		forks = new Object[num];
		philosophers = new Philosopher[num];
		for(int i = 0; i < num; i++){
			this.text.setText(String.valueOf(i));
			this.shell.update();
			
			forks[i] = new Object();
			int fork1 = i;
			int fork2 = (i+1)%num;
			if(i == 0)
				philosophers[0] = new Philosopher(0, fork2, fork1);
			else
				philosophers[i] = new Philosopher(i, fork1, fork2);
		}
	}
	
	public void startEating() throws InterruptedException{
		for(int i = 0; i < philosophers.length; ++i)
			philosophers[i].start();
		philosophers[0].join();
	}
	
	public class Philosopher extends Thread{
		int fork1;
		int fork2;
		int id;
		public Philosopher(int i, int j, int k) {
			this.id = i;
			this.fork1 = j;
			this.fork2 = k;
		}
		public void run(){
			status("Ready to eat using forks " + fork1 + " and " + fork2);
			pause();
			while(true){
				pause();
				
				status("Picking up " +fork1);
				synchronized(forks[fork1]){
					status("Picking up " + fork2);
					synchronized(forks[fork2]){
						status("Eating");
					}
				}
			}
		}
		
		private void status(String msg){
			System.out.println("Philosopher " + id + ": " + msg);
		}
		private void pause(){
			try{
				sleep(2000);
			}
			catch(InterruptedException e){
			}
		}
		
	}
	public static void main(String val, Text text_box){
		/*try{
			DiningPhilosophers d = new DiningPhilosophers(Integer.parseInt(val));
			d.startEating();
		}catch(InterruptedException e){
		}*/
	}
}
