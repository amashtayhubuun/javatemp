package ru.homeworks.threadpool;

/**
 * Created by Alexander on 29.09.2016.
 */
public class Task implements Runnable {
    int balance=0;
    @Override
    public void run() {
        System.out.printf("Поток %s начал свою работу.\n",Thread.currentThread().getName());
    }
}
