public class MultiThread {
    public static void main(String[] args) {
      /*  MyThread thread1 = new MyThread();
        thread1.task = "Стирать";
        MyThread thread2 = new MyThread();
        thread2.task = "Гладить";
        thread1.start();
        thread2.start();*/
   /*     Thread thread1 = new Thread(new MyRunnabelClass("Мыть посуду"));
        Thread thread2 = new Thread(new MyRunnabelClass("Стирать белье"));
        Thread thread3 = new Thread(new MyRunnabelClass("Убегать"));
        thread1.start();
        thread2.start();
        thread3.start();*/
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Мыть посуду" + " - выполнен на " + i + " %");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Стирать" + " - выполнен на " + i + " %");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

class MyRunnabelClass implements Runnable {

    String task;

    public MyRunnabelClass(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(task + " - выполнен на " + i + " %");
        }
    }
}

class MyThread extends Thread {
    String task;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(task + " - выполнен на " + i + " %");
        }
    }
}