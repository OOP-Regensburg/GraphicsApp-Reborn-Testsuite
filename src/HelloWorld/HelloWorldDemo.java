package HelloWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class HelloWorldDemo {

    private static final String INPUT_PROMPT_SUFFIX = ": [Bitte mit der Eingabetaste bestätigen]";
    private static final String LOG_FILE = "user_log.txt";

    public static void main(String[] args) {
        String userName = readString("Bitte gib deinen Namen ein");
        System.out.println("Hallo " + userName + "! Herzlich willkommen in der wunderbaren Welt von Java!");
        logUserGreeting(userName);
    }

    public static String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        printCurrentUserGreetings();
        System.out.println(prompt + INPUT_PROMPT_SUFFIX);
        String input = scanner.nextLine();
        return input;
    }

    public static void printCurrentUserGreetings() {
        Scanner scanner = null;
        System.out.println("Current log of greeted users: ");
        try {
            scanner = new Scanner(new File(LOG_FILE));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.next();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void logUserGreeting(String userName) {
        Date now = new Date();
        String str = "World";
        try {
            FileWriter fileWriter = new FileWriter(LOG_FILE, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(now.toGMTString() + "\t" + "Greeted " + userName);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
