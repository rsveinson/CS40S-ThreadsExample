/**
 * Two hungry people, anxiously waiting for their turn to take soup
 */

import java.util.concurrent.locks.*;

class HungryPerson extends Thread {

    private int personID;
    private static Lock slowCookerLid = new ReentrantLock();
    private static int servings = 11;
    private static Condition soupTaken = slowCookerLid.newCondition();

    public HungryPerson(int personID) {
        this.personID = personID;
    }

    public void run() {
        while (servings > 0) {
            slowCookerLid.lock();
            try {
                while ((personID != servings % 5) && servings > 0) { // check if it's not your turn
                    System.out.format("Person %d checked... then put the lid back.\n", personID);
                    /* if it's not my turn I'll wait here (the tread is interuppted)
                     * and I'll give up the lock i.e. the slowCookerLid is not locked
                     * when we eventually get back here we'll re-aquire the lock
                     * and pick up exection after
                     * the await() line and head back up to while to see if it's my turn
                     */
                    soupTaken.await();
                }
                if (servings > 0) {
                    servings--; // it's your turn - take some soup!
                    System.out.format("Person %d took some soup! Servings left: %d\n", personID, servings);
                    /* signal all waiting threads that I'm done
                     * so that they can pick up their exectution
                     * threads are notified FIFO
                     */
                    soupTaken.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                    slowCookerLid.unlock();
            }
        }
    }
}

public class ConditionVariableDemo {
    public static void main(String args[]) {
        for (int i=0; i<5; i++)
            new HungryPerson(i).start();
    }
}