
public class ThreadLocalTest {

	public static void main(String [] args){

		ThreadLocalTest test = new ThreadLocalTest();


		Thread t1 = new Thread(new MyRunnable(1));
		Thread t2 = new Thread(new MyRunnable(2));
		Thread t3 = new Thread(new MyRunnable(3));

		System.out.println("Starting Execution of Threads...");		
		t1.start();
		t2.start();
		t3.start();		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Thread Execution complete...");
	}


	static class MyRunnable implements Runnable{
		private int threadNum;
		ThreadLocal localVar = new ThreadLocal<Integer>(){
			public Integer initialValue(){
				return 100;
			}
		};
		private MyRunnable() { }	

		public MyRunnable(int threadNum) {
			this.threadNum = threadNum;

		}

		@Override
		public void run() {
			System.out.println("Thread local var:"+localVar.get()+" for Thread:"+ threadNum);
			localVar.set(threadNum);
			System.out.println("Execution of Thread - " + this.threadNum);
			for(int i=0;i<10;i++){
				System.out.println("Thread local var:"+localVar.get()+" for Thread:"+ threadNum);
			}
		}

	}
}


