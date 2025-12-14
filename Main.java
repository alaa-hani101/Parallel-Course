public class Main {
    static int counter = 0; // Shared resource
    public static void main(String[] args) throws  InterruptedException{
//        Thread thread = new MyThread();
//        thread.start();
//
//        Runnable task = new MyTask();
//        Thread t = new Thread(task);
//        t.start();
//
        // Thread Naming
//        Thread t1 = new Thread("MyFirstTask");
//        t1.start();
//        System.out.println("Thread Name : "+ t1.getName());

//        Thread t2 = new Thread();
//        t2.setName("MySecondThread");
//        System.out.println("Thread Name : "+ t2.getName());

        //  Naming Threads with Runnable
//        Runnable task = () -> System.out.println("Running in: " + Thread.currentThread().getName());
//        Thread t3 = new Thread(task, "RunnableThread");
//        t3.start();

        // Thread Priority
//        Thread t1 = new Thread(() ->
//                System.out.println("Thread 1 Priority: " + Thread.currentThread().getPriority())
//        );
//
//        Thread t2 = new Thread(() ->
//                System.out.println("Thread 2 Priority: " + Thread.currentThread().getPriority())
//        );
//
//        t1.setPriority(Thread.MIN_PRIORITY); // 1
//        t2.setPriority(Thread.MAX_PRIORITY); // 10
//
//        t1.start();
//        t2.start();


                // Thread States
//        Thread t4 = new Thread(() -> {
//            System.out.println("State inside run(): " +
//                    Thread.currentThread().getState());
//        });
//
//        // State 1: NEW
//        System.out.println("Before start(): " + t4.getState());
//
//        // State 2: RUNNABLE
//        t4.start();
//        System.out.println("After start(): " + t4.getState());
//
//        // Wait until the thread finishes
//        t4.join();
//
//        // State 3: TERMINATED
//        System.out.println("After completion: " + t4.getState());

        // Grouping Threads

//        ThreadGroup myGroup = new ThreadGroup("MyGroup");
//
//        Thread t1 = new Thread(myGroup, () -> {
//            System.out.println(Thread.currentThread().getName() + " in " +
//                    Thread.currentThread().getThreadGroup().getName());
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "Thread-1");
//
//        Thread t2 = new Thread(myGroup, () -> {
//            System.out.println(Thread.currentThread().getName() + " in " +
//                    Thread.currentThread().getThreadGroup().getName());
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "Thread-2");
//
//        t1.start();
//        t2.start();
//
//        Thread.sleep(50);
//
//        System.out.println("Active Threads in Group: " + myGroup.activeCount());
//        myGroup.list();


        // try-catch handle exception

//        Worker t1 = new Worker();
//        Worker t2 = new Worker();
//        Worker t3 = new Worker();
//
//        t1.start();
//        t2.start();
//        t3.start();


        // setUncaughtExceptionHandler

//        Worker t1 = new Worker();
//
//        t1.setUncaughtExceptionHandler((thread, exception)->{
//
//            System.out.println("Exception in: "+ t1.getName() +
//
//                    "  --->  "+ exception.getMessage());
//        });
//
//        t1.start();
//
//        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
//            System.out.println("Global handler caught exception in thread: " + thread.getName());
//            System.out.println("Error Message: " + exception.getMessage());
//        });
//
//
//        Thread t1 = new Thread(() -> {
//            throw new RuntimeException("Thread t1 crashed unexpectedly!");
//        });
//
//        Thread t2 = new Thread(() -> {
//                throw new ArithmeticException("Division by zero occurred on purpose!");
//        });
//
//
//        System.out.println("Starting threads...");
//        t1.start();
//        t2.start();

           // race condition
//        Thread t1 = new Thread(new MyTask(), "Thread-1");
//        Thread t2 = new Thread(new MyTask(), "Thread-2");
//
//        t1.start();
//        t2.start();

        // syncronized


    }


    public class Counter {

        private int count = 0;
        public syncronized void increment(){
            count++;
        }
        public syncronized int getcount(){

            return count;
        }
    }
    static class MyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int current = counter;
                try {
                    // Small delay to increase overlap
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int updated = ++counter;
                System.out.println(Thread.currentThread().getName()
                        + " -> Current: " + current + ", Updated: " + updated);
            }
        }
    }
}

