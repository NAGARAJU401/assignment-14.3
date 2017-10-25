package notifytester;
//created package name as notifytester
class Waiter implements Runnable{
	//Reference variable of message class
	private Display txt;
	//Constructor of Waiter class and passing the reference as argument
	public Waiter(Display m){
		txt=m;
		
	}
	//Overriding the run method as we have implemented runnable interface
	@Override
	public void run() {
		//Getting the name of the current running thread
		String name= Thread.currentThread().getName();
		// Applying the Synchronized keyword  so that only one thread can get access at a time
		synchronized (txt) {
			//the try block
			try {
				//Thread 1
				System.out.println(name+"  waiting to get notified at time"+System.currentTimeMillis());
				//putting the thread on wait
				txt.wait();
				//Catch block
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//thread 2
			System.out.println(name+ " waiter Thread is notified at time"+System.currentTimeMillis());
			//process the message now
			System.out.println(name+" proceesed "+ txt.getTxt());
		}
		
	}
}
public class NotifyTest {
	//public : members which can access as public,public members are visible to all other classes.
			//class : is a context of java that are used to create objects and to define object data types and methods.
			//classes are the basics of opps(object oriented programming)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Public is a keyword that is used as an access modifier for methods and variables.
		//static used to prepare a field,method or inner classes as a class field.
		//void: it is void if the method does not return a value.
	//main:it is a function name When a program starts running, it has to start execution from somewhere.
		//String[] args: it is  defining a String array to pass arguments at command line. args is the variable name of the String array.
		Display txt= new Display("done it");
		//created object of waiter class
		Waiter waiter= new Waiter(txt);
		//constructor of thread class,passing reference and calling the start method
		new Thread(waiter,"Waiter").start();;
		//created object of waiter1 class
		Waiter waiter1= new Waiter(txt);
		//constructor of thread class,passing reference and calling the start method
		new Thread(waiter1,"Waiter1").start();
		//created object of Notifier class
		Notifier notifier= new Notifier(txt);
		//constructor of thread class,passing reference and calling the start method
		new Thread(notifier,"notifier").start();
		//print line
		System.out.println("All thread started");
		
	}

}
