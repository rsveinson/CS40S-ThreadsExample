/*
 * This program demonstrates how to lock an object using synchronization
*   the synchronized keyword identifies the object on which the lock will be aquired
*   the critical section of code is enclosed in {}
*   once entered the critical code must complete before the block is released
 */
 

/**
 *
 * @author MFisher
 */
public class SynchronizedBlocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Countdown CD = new Countdown();
        Runnable r = () -> {
     // un-comment the next line and closing curly brace to see a block in action
        //synchronized(CD) {
         CD.printCount();
        //}
    };
        Thread one = new Thread(r,"one");
        Thread two = new Thread(r,"two");
        one.start();
        two.start();
    }
}
 class Countdown {
    public void printCount() {
      try {
         for(int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + ": "  + i );
         }
         System.out.println("BlastOff!" + Thread.currentThread().getName());

      }catch (Exception e) {
         System.out.println("Thread  interrupted.");
      }
   }
}


