import java.io.FileInputStream;
import java.io.IOException;

public class ProxyChecker {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://java/ip.txt");
            int i;
            String socket = "";
            while ((i = fis.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    String ip = socket.split(":")[0];
                    String port = socket.split(":")[1];
                    System.out.println("IP:\t"+ip+" \t port : "+port);
                    socket = "";
                } else {
                    socket += (char) i;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
