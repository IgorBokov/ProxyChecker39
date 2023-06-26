package DZ_ALL.DZ1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToHardDrive {
    public static void main(String[] args) {
        try {
            FileWriter createTextFile = new FileWriter("C:\\Java\\testwrite.txt",true);
            String transmissionText = "Текст для записи в файл";
            createTextFile.append(transmissionText + "\n");
            createTextFile.flush();
            createTextFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("C:\\Java\\FileExample.txt");
        try {
            FileWriter fw = new FileWriter(file);
            String transText = "File file = new File";
            fw.append(transText);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
