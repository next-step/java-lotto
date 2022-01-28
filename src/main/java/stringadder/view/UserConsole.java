package stringadder.view;

import java.util.Scanner;

public class UserConsole {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString(){
        return scanner.nextLine();
    }
}
