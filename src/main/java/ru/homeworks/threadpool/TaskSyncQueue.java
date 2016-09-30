package ru.homeworks.threadpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alexander on 25.09.2016.
 */

// TODO Очередь заданий. Должна принимать задачи, то есть любой класс реализующий Runnable().
public class TaskSyncQueue<T extends Runnable> {
    private Queue<T> queue=new LinkedList<>();

    // TODO: констркутор

    // TODO: 25.09.2016 Добавление в очередь(должно быть синхронизованно)
    public void addLast(T task){
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }
    // TODO: 25.09.2016 Извлечение из очерди(так же должно быть синхронизовано)
    public T getFirst() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                queue.wait();
            }
            return queue.remove();
        }
    }

    // TODO: 29.09.2016 Проверка на наличие элементов
    public boolean isEmpty(){
        boolean result;
        synchronized (queue){
            result=queue.isEmpty();
        }
        return result;
    }
}
