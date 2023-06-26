import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://java/test.txt");
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String text = "\nHello";
        try {
            FileOutputStream fos = new FileOutputStream("C://java/test.txt", true);
            byte[] bufer = text.getBytes();
            fos.write(bufer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}