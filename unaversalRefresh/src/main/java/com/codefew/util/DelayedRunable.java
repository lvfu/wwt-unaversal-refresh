package com.codefew.util;

/**
 * Created by flowing on 2018/2/9.
 * @version 1.0
 * @author wangwentao
 *
 * 延迟线程
 *
 */

public class DelayedRunable implements  Runnable{

    public long delayMillis;
    public Runnable runnable = null;
    public DelayedRunable(Runnable runnable) {
        this.runnable = runnable;
    }
    public DelayedRunable(Runnable runnable, long delayMillis) {
        this.runnable = runnable;
        this.delayMillis = delayMillis;
    }
    @Override
    public void run() {
        try {
            if (runnable != null) {
                runnable.run();
                runnable = null;
            }
        } catch (Throwable ignored) {
        }
    }
}
