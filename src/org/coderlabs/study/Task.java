package org.coderlabs.study;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Ninglee on 15/8/23.
 */
public class Task implements Callable<Integer> {

    private String instId;

    public Task(String name){
        instId = name;
    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep(500);

        System.out.println(Thread.currentThread().getName() + " process instId " + instId + ", size " + Queue.getInstance().size());
        //return the thread name executing this callable task
        Random random = new Random();
        int result = random.nextInt() % 2;

        if (result == 0) {
            System.out.println("process inst " + instId + " success");
        }
        else
        {
            Queue.getInstance().add(instId);
            System.out.println("process inst " + instId + " failed" + ", size " + Queue.getInstance().size());
        }
        return 0;
    }

}
