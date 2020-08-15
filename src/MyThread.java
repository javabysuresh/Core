import java.util.*;
class MyThread extends Thread
{
	static ArrayList<String> l=new ArrayList<String>();
	
	public void run(){
		try{
		Thread.sleep(2000);}
		catch(InterruptedException ie){}
		System.out.println("Child Thread is updating");
		l.add("D");
	}

	public static void main(String[] args)throws InterruptedException  
	{
		l.add("A");
		l.add("B");
		l.add("C");
		MyThread mt=new MyThread();
		mt.start();

		Iterator<String> itr=l.iterator();
		while(itr.hasNext()){
			String s=(String)itr.next();
			System.out.println("Main Thread is Excuting: " +s);
			Thread.sleep(1000);
		}
		System.out.println(l);
	}
}
