class Worker extends Thread {
    public void run() {
//        try {
            System.out.println(Thread.currentThread().getName() + " started.");
            int result = 10 / 0; // This will throw ArithmeticException
//        } catch (Exception e) {
//            System.out.println(Thread.currentThread().getName() + " caught: " + e);
//        }
//        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}