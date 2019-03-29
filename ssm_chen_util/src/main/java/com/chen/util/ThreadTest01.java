package com.chen.util;

public class ThreadTest01 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        new Thread(myThread01).start();
        MyThread02 myThread02 = new MyThread02();
        myThread02.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(444);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(555);
                }
            }
        }).start();


        for (int i = 0; i < 1000; i++) {
            System.out.println(111);
        }
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
class MyThread01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(222);
        }
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(333);
        }
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
