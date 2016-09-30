package ru.homeworks.threadpool;

/**
 * Created by Alexander on 29.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Threadpool<Task> threadpool=new Threadpool<>(5);

        Task task=new Task();
        for (int i = 0; i < 10; i++) {
            threadpool.addTask(task);
        }



    }
}
