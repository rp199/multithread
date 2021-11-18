package com.rp199.multiexecutor;

import java.util.List;
import java.util.stream.Collectors;

public class MultiExecutor {

    private List<Thread> threads;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        threads = tasks.stream().map(Thread::new).collect(Collectors.toList());
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        threads.forEach(Thread::start);
    }

}
