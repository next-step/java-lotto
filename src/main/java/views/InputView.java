package views;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputExpression(String query) {
        System.out.println(query);
        return scanner.nextLine();
    }
}
