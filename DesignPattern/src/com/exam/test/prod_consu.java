package com.exam.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class prod_consu {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
        Producer p2 = new Producer(c, 2);
        Consumer c2 = new Consumer(c, 2);
        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }
}

class CubbyHole {
    private Queue<Integer> contents = new LinkedList<>();
    private boolean available =  false;
    public synchronized int get(){
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        available = false;
        notifyAll();
        return contents.poll();
    }

    public synchronized void put(int value){
        while(available==true){
            try {
                wait();
            }
            catch (InterruptedException e){

            }
        }
        contents.add(value);
        available = true;
        notifyAll();
    }
}

class Consumer extends Thread{
    private CubbyHole cubbyHole;
    private int number;
    public Consumer(CubbyHole c, int number){
        cubbyHole = c;
        this.number = number;
    }
    public void run(){
        int value = 0;
        for(int i = 0; i<10; ++i){
            value = cubbyHole.get();
            System.out.println("消费者#" + this.number + "got:" +value);
        }
    }
}

class Producer extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Producer(CubbyHole c, int number){
        cubbyHole = c;
        this.number = number;
    }

    public void run(){
        for (int i=0; i<10; i++){
            cubbyHole.put(i);
            System.out.println("生产者 #" + this.number + "put:" + i);
            try {
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                System.out.println("生产者 #" + this.number + "被打断");
            }
        }
    }
}
