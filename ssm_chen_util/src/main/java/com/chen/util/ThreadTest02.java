package com.chen.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest02 {
    public static void main(String[] args) {
        MyThread myThread1=new MyThread();

        new Thread(myThread1).start();
        new Thread(myThread1).start();
        new Thread(myThread1).start();
    }
}

class MyThread implements Runnable{
    private Lock lock=new ReentrantLock();
    private int num=100;
    @Override
    public void run() {
        while(true){
            lock.lock();
            if (num>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
                num--;
            }
            lock.unlock();
        }
    }
}
