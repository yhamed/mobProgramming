package com.rainbow.mobProgramming;

import org.springframework.beans.factory.annotation.Value;

import java.awt.*;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class Mob implements Runnable {

    @Value("quantum")
    private int quantum;

    Global global = new Global();

    private Notify notify = new Notify();
    int i = 0;
 private LinkedList<String> mobParticipants = new LinkedList<>();
    public Mob() {

        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void run() {


while (true) {

    final WaitableTimerTask waitableTimerTask = new WaitableTimerTask() {
        @Override
        public void run() {
            try {
                notify.sendNotification(global.mobParticipants[global.i]);
            } catch (AWTException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            if (global.i + 1 < mobParticipants.size()) {
                global.i++;
            } else {
                global.i = 0;
            }
            System.out.println("TimerTask was run.");
        }
    };
    new Timer(true).schedule(waitableTimerTask, 10000, 10000);
    // Some other thread will need to cancel it.
    try {
        waitableTimerTask.await();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
}

    }
}
