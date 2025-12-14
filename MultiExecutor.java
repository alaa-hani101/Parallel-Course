import java.util.ArrayList;
import java.util.List;

/**
 * MultiExecutor executes a list of Runnable tasks in parallel,
 * with one thread per task.
 */
public class MultiExecutor {

    private final List<Runnable> tasks;
    private final List<Thread> threads;


    public MultiExecutor(List<Runnable> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("Tasks list cannot be null.");
        }
        this.tasks = new ArrayList<>(tasks);
        this.threads = new ArrayList<>();
    }


    public void executeAll() {

        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

    }


    public void joinAll() throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All tasks completed.");
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Task 1 started.");
        };

        Runnable task2 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Task 2 started.");
        };

        Runnable task3 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Task 3 started.");
        };

        List<Runnable> tasksToExecute = new ArrayList<>();
        tasksToExecute.add(task1);
        tasksToExecute.add(task2);
        tasksToExecute.add(task3);

        MultiExecutor executor = new MultiExecutor(tasksToExecute);

        long startTime = System.currentTimeMillis();
        executor.executeAll();

        executor.joinAll();
        long endTime = System.currentTimeMillis();

        System.out.println("Main thread continues after all tasks. Total execution time: " + (endTime - startTime) + "ms");
    }
}