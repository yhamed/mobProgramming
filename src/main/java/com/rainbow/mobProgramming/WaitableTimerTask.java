package com.rainbow.mobProgramming;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

abstract class WaitableTimerTask extends TimerTask {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public boolean cancel() {
        boolean result = super.cancel();
        countDownLatch.countDown();
        return result;
    }

    public void await() throws InterruptedException {
        countDownLatch.await();
    }
}