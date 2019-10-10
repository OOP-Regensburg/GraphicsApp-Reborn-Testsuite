package FileDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemoLauncher {
    private static void saveAFile() {
        String myPath = "data/test.txt";
        try(FileWriter fileWriter = new FileWriter(myPath)) {
            String fileContent = "OOP ist ein wichtiger und wertvoller Bestandteil einer Informatik-Diät.";
            fileWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadAFile() {
        String myPath = "data/test.txt";
        try(FileReader fileReader = new FileReader(myPath)) {
            int ch = fileReader.read();
            while(ch != -1) {
                System.out.print((char)ch);
                ch = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        loadAFile();
        saveAFile();
    }
}
