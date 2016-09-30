package ru.homeworks.threadpool;

/**
 * Created by Alexander on 25.09.2016.
 */
public class Threadpool<T extends Runnable> {
    private PoolHandler[] poolHandlers;
    private int numberOfThreads;
    private TaskSyncQueue<T> taskSyncQueue=new TaskSyncQueue<>();;

    // констркутор пула
    // TODO: 25.09.2016 наложить условия на numberOfThreads
    public Threadpool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        poolHandlers = new PoolHandler[this.numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            poolHandlers[i] = new PoolHandler(taskSyncQueue);
            poolHandlers[i].start();
        }
    }

    // добавление задачи в очередь
    public void addTask(T t) {
        if (t != null) {
            taskSyncQueue.addLast(t);
        }
    }



    // TODO очистка очереди


}
