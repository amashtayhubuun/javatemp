package ru.homeworks.threadpool;

/**
 * Created by Alexander on 30.09.2016.
 */
public class PoolHandler<T extends Runnable> extends Thread {
    private TaskSyncQueue<T> taskSyncQueue;

    public PoolHandler(TaskSyncQueue<T> taskSyncQueue) {
        this.taskSyncQueue = taskSyncQueue;
    }

    @Override
    public void run() {
        Runnable work;
        while (true){
            // будем ожидать задачи из очереди
            try {
                work=(Runnable)taskSyncQueue.getFirst();
                work.run();
            } catch (InterruptedException e) {
                // TODO: 30.09.2016 обработать исключение
            }
        }

    }
}
