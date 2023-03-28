/*
 * This is a sample main program to show how to use the 
 * synchronized keyword to prevent multiple threads from 
 * corrupting our data
 */
 

/**
 *
 * @author MFisher
 */
public class IdWithSynchronization {

  //define a class variable called counter
     static int counter = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
/* Example of locking using a synchronized method */
    
       //use lambda notation for the runnable method 
       // Runnable r = () -> {
           // System.out.println("ID value of " + Thread.currentThread().getName() +": " + getID());
           // try{
               // //stop the thread for 1/2 second
               // Thread.sleep(500); 
               // //System.out.println("ID value of " + Thread.currentThread().getName() +": " + getID());
               // }
           // catch(Exception e){System.out.println(e);}        
       // };
       // Thread one = new Thread(r,"one");
       // one.start();
       
       // Thread two = new Thread(r,"two");
       // two.start(); 
   // }

/*  Example of locking using an object */
    //use lambda notation for the runnable method 

        Runnable r2 = () -> {
            ID id = new ID();
            System.out.println("ID value of " + Thread.currentThread().getName() + ": " + id.getID());
        };
        Thread one = new Thread(r2,"one");   
        one.start();
        Thread two = new Thread(r2,"two");
        two.start();     
    }

    public static synchronized int getID()
    {
        return counter++;
    }
    
} // end class

/*
 * ID Class contains the synchronized keyword to prevent
 * multiple threads from accessing the getID() method at the same time
 */

class ID {
   private static int counter; // initialized to 0 by default

   public static synchronized int getID()
   {
      return counter++;
   }

    
} // end class ID

