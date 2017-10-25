package notifytester;
//created package name as notifytester
public class Notifier implements Runnable {
	//creating class named as Notifier which implements Runnable 
			//Reference variable of Display class
		private Display txt;
		//Constructor of Notifier class and passing the reference as argument
		public Notifier(Display m){
			txt=m;
		}
		@Override
		public void run() {
			
			//Getting the name of the current running thread
			String name= Thread.currentThread().getName();
			
			//print line it should print the name of thread along with message we have passed
			System.out.println(name +" get started");
			
			try {
				//here we are putting our main Thread on sleep
				Thread.sleep(1000);
				//applying synchronized keyword and handing the exception
				synchronized (txt) {
					//called the settxt method and pass the message of display 
					txt.setTxt(name+"Notifer has done his work");
					//txt.notify();
					txt.notifyAll();
					
				}
			} catch (InterruptedException e) {
				
				
				
				e.printStackTrace();
			}
			
			
		}
}
