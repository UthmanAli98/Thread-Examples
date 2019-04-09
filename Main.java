import java.util.Random;

class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;
   
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            
            Random rand  = new Random();
            int n = rand.nextInt(10000);
            Thread.sleep(n);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}

public class Main{

   public static void main(String args[]) {
      RunnableDemo R1 = new RunnableDemo( "The First Thread");
      R1.start();
      
      RunnableDemo R2 = new RunnableDemo( "The Second Thread");
      R2.start();
   }   
}