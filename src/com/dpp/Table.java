/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpp;

import java.util.ArrayList;
/**
 *
 * @author Marcin
 */
public class Table {
    private ArrayList<Object> forks = new ArrayList<>();
    private ArrayList<Philosopher> philosophers = new ArrayList<>();
    
    public void startDinner(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            forks.add(new Object());
        }
        for (int i = 0; i < n; i++) {
            philosophers.add(new Philosopher(i + 1, forks.get(i), forks.get((i + 1) % n)));
        }
        for (int i = 0; i < n; i++) {
            philosophers.get(i).start();
        }
        for (int i = 0; i < n; i++) {
            philosophers.get(i).join();
        }
    }
}
