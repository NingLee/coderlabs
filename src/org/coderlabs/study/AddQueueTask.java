package org.coderlabs.study;

import java.util.Random;

/**
 * Created by Ninglee on 15/8/23.
 */
public class AddQueueTask implements Runnable {
    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();

            int digital = random.nextInt();
            Queue.getInstance().add(String.valueOf(digital));

            System.out.println("adding " + String.valueOf(digital) + " to the queue. size " + Queue.getInstance().size());
        }

    }
}
