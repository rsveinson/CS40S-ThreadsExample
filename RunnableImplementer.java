 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sveinson-r
 * 
 */
public class RunnableImplementer implements Runnable{
    public void run(){
        System.out.println("this is the thread: " + Thread.currentThread().getName());
        
        System.out.println("this thread was created by implementing the runnable interface class");        
    } // end run
    
}
