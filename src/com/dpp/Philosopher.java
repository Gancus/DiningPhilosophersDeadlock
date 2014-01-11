/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcin
 */
public class Philosopher extends Thread {
    private int id;
    private Object leftFork, rightFork;
    private int eatCouter = 0;

    public Philosopher(int id, Object leftFork, Object rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    
    
    @Override
    public void run() {
        while(eatCouter <= 100) {
            try {
                think();
                synchronized (leftFork) {
                    synchronized (rightFork) {
                        eat();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void think() throws InterruptedException {
        /*System.out.println(this + " zaczyna myśleć");
        System.out.println(this + " myśli");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(this + " kończy myśleć");*/
    }
    
    public void eat() throws InterruptedException {
        System.out.println(this + " zaczyna jeść");
        System.out.println(this + " je");
        eatCouter++;
        //TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(this + " kończy jeść");
    }

    @Override
    public String toString() {
        return "Filozof{" + "id=" + id + '}';
    }
    
    
}
