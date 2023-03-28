/*
 * deomonstrate how to create threads and how to run/start them
 */
 

/**
 *
 * @author sveinson-r
 */
public class ThreadsIntro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a thread using a class that implements runnable
        (new Thread(new RunnableImplementer(), "Big Thread")).start();
        
        // create a thread using a class that extends Thread
        (new ThreadExtender()).start();
        
//        // using anonymous inner classes to create one off runnable objects
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                System.out.println("this is the thread: " + Thread.currentThread().getName());
                System.out.println("this thread was created passing a runnable object");
                System.out.println("into a Thread constructor");
            } // end run
        }; // end of r1
        
//        // using anonymous inner class and lambda notation
        Runnable r2d2 = () -> {System.out.println("this is thread: " + Thread.currentThread().getName());
        System.out.println("toString: " + Thread.currentThread().toString());
        System.out.println("runnable created using lambda notation");};
//        
//        // the runnables r1 and r2d2 aren't threads yet, they will be used as arguments to
//        // a thread constructor
//        
        Thread t1 = new Thread(r1, "SuperThread");
        t1.start();
        
        Thread t2 = new Thread(r2d2, "the droid you're looking for");
        t2.start();
    } // end main
    
} // end class
