/* 
*   A race condition is present when the sleep time is set to 0. The correctness of
*   the computation depends on the timeing of the threads by the scheduler
*   it is possible that the scheduler will suspend thread A before it completes its computation
*   i.e. before it does b = a / 2
*   when this happens thread b takes over and sets a = 12, so the result 
*   when thread A reumes will be 12 / 2 = 6
*
*   there is a data race when sleep time is set since both threads use the static variable
*   a, if thdA is gets the data and goes off to do its work wich includes
*   a sleep . While the sleep is on thread b slips in and does it's work
*   setting a = 12 
*   b = a / 2, the result will be unexpected
*   the problem doesn't arise very often because things are happening so 
*   so quickly but if we add a Thread.sleep(50) it occurs almost all of the time
*/
 

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Producer
 */
public class RaceAndDataRaceExample {
    static double a = 10;
    static double b; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Runnable r1 = ()->
            {
                //System.out.println("let's get started with " + Thread.currentThread().getName());
                System.out.println("a = " + a);
                if(a == 10)
             try {
                 Thread.sleep(0);
                 b = a/2.0;
                 System.out.println(Thread.currentThread().getName() + ": " + b);
             } catch (InterruptedException e) { }
            };
         Runnable r2 = () -> {
               a = 12; 
               System.out.println("ha, I'm " + Thread.currentThread().getName());
            };
        Thread thdA = new Thread(r1, "Thread A");
        Thread thdB = new Thread(r2, "Thread B");
        thdA.start();
        thdB.start();
        
    }
    
}
