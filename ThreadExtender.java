 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sveinson-r
 */
public class ThreadExtender extends Thread{
    
    // must override the run() method
    public void run(){
        System.out.println("this is the thread: " + Thread.currentThread().getName());
        System.out.println("this thread was created by extending the Thread class");
    } // end run
    
} // end class
