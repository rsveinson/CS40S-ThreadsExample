/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author mfisher
 */
public class HelloRunnable implements Runnable{
     public void run() {
        System.out.println("Hello from "+Thread.currentThread().getName()+" "
                + "a thread created by "
                + "implementing a Runnable Interface!");
    }
    
}
