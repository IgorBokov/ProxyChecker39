package DZ_ALL.DZ1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadHardDrive {
    public static void main(String[] args) throws IOException {

        FileReader readTextFile;
        try {
            readTextFile = new FileReader("C:\\Java\\ip.txt");
            char[] tenpBuferReadFile = new char[256];
            int c;
            while (true) {
                try {
                    if (!((c = readTextFile.read(tenpBuferReadFile)) > 0)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (c < 256) {
                    tenpBuferReadFile = Arrays.copyOf(tenpBuferReadFile, c);
                }
                System.out.println(tenpBuferReadFile);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        readTextFile = new FileReader("C:\\Java\\test.txt");
        int buf;
        while ((buf = readTextFile.read()) != -1) {
            System.out.print((char) buf);
        }
    }
}
