/*
 * This program is used to demonstrate using synchronization with threads
 *   two threads using a shared resource, in this case the static variable id
 *   it is possible that both threads will get 1 from id because when one thread sleeps
 */

/**
 *
 * @author MFisher
 */
public class IdWithoutSynchronization {
    //define a class variable called counter
    static int counter = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //use lambda notation for the runnable method 
        Runnable r = () -> {
                //System.out.println("ID value of " + Thread.currentThread().getName() +": " + getID());
                try{
                    //stop the thread for 1/2 second
                    Thread.sleep(50);
                    System.out.println("ID value of " + Thread.currentThread().getName() +": " + getID());

                }
                catch(Exception e){System.out.println(e);}        
            };
        // thread one is started first, you'd think that it would get its id (1)
        // and increment the shared resouce before two does its work
        // the Thread.sleep(500) puts one to sleep for half a second, more than 
        // enough time for two to start, get its id, and increment it
        Thread one = new Thread(r,"one");
        one.start();

        // you'd expect two to have an id of 2
        // but since one goes to sleep for 1/2 second the scheduler
        // will sometimes suspend one and pass execution to two
        Thread two  = new Thread(r,"two");
        two.start(); 
    }

    public static int getID()
    {
        return counter++;
    }  
}
