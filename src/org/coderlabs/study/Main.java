package org.coderlabs.study;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String args[]) {

        Thread t = new Thread(new AddQueueTask());

        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ConcurrentLinkedQueue<String> q = Queue.getInstance();
            String instId = q.poll();

            if (instId == null)
            {
                System.out.println("Queue is Empty " + Queue.getInstance().size());
                System.exit(0);
            }

            Task task = new Task(instId);

            Future<Integer> future = executor.submit(task);

        }
    }

}
