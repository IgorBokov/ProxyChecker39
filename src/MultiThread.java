import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class MultiThread {
    public static void main(String[] args) {
        /*MyThread thread1 = new MyThread();
        thread1.task = "МЫть посуду";
        MyThread thread2  = new MyThread();
        thread2.task = "Стирать белье";
        MyThread thread3 = new MyThread();
        thread3.task = "Пылесосить";
        thread1.start();
        thread2.start();
        thread3.start();*/
        /*Thread thread1 = new Thread(new MyRunnableClass("МЫть посуду"));
        Thread thread2 = new Thread(new MyRunnableClass("Стирать белье"));
        Thread thread3 = new Thread(new MyRunnableClass("Пылесосить"));
        thread1.start();
        thread2.start();
        thread3.start();*/
       /* Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Мыть посуду - выполнен на " + i + "%");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Стирать белье - выполнен на " + i + "%");
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Пылесосить - выполнен на " + i + "%");
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();*/
    }
}

class MyRunnableClass implements Runnable {
    String ip;
    int port;

    public MyRunnableClass(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        ProxyChecker.checkProxy(ip,port);
    }
}

class MyThread extends Thread {
    String ip;
    int port;

    public MyThread(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection connection = url.openConnection(proxy);
            InputStream is = connection.getInputStream();
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
            FileOutputStream fos = new FileOutputStream("C://java/validIp.txt",true);
            byte[] tempIp = (ip+" "+port).getBytes();
            fos.write(tempIp);
            fos.flush();
            fos.close();

        } catch (IOException e) {
            System.out.println(ip + "\t-\tНЕ РАБОТАЕТ");
        }
    }
}