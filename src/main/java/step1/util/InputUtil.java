package step1.util;

import java.util.Scanner;

public class InputUtil {
    public static Scanner scanner = new Scanner(System.in);

    public static String returnString(String question) {
        System.out.println(question);
        String result = scanner.next();
        if (result.contains("\\n")) {
            result = result.replace("\\n", "\n");
        }
        return result;
    }
}
