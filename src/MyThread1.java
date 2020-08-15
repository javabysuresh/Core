import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
class MyThread1 extends Thread
{
	//static HashMap<Integer, String> hs=new HashMap<>();
	static ConcurrentHashMap<Integer, String> hs= new ConcurrentHashMap<>();
	public void run(){
		try{
			Thread.sleep(2500);}
		catch(InterruptedException e){}
		System.out.println("Child Thread is updating");
		hs.put(4,"sss");
	}

	public static void main(String[] args)throws InterruptedException  
	{
		hs.put(1,"A");
		hs.put(2,"B");
		hs.put(3,"C");
		MyThread mt=new MyThread();
		mt.start();
		Set<Integer> s=hs.keySet();
		Iterator<Integer> itr=s.iterator();
		while(itr.hasNext()){
			Integer s1=(Integer)itr.next();
			System.out.println("Main Thread is Excuting: " +s1+"......."+hs.get(s1));
			Thread.sleep(3000);
		}
		System.out.println(hs);//prints
	}
}
