package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final String ENTER = "\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        StringBuilder sb = new StringBuilder();

        String firstLine = scanner.nextLine();
        if (firstLine.startsWith("//")) {
            String secondLine = scanner.nextLine();
            sb.append(firstLine+ENTER).append(secondLine);
            return sb.toString();
        }

        return firstLine.trim();
    }
}
