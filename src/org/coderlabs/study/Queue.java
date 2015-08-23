package org.coderlabs.study;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Ninglee on 15/8/23.
 */
public class Queue extends ConcurrentLinkedQueue<String> {

    private Queue()
    {

    }

    private static class SingletonHolder {
        private final static Queue INSTANCE = new Queue();
    }

    public static Queue getInstance(){

        return SingletonHolder.INSTANCE;
    }

}
