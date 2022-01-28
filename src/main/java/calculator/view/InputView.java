package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final String ENTER = "\n";

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

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
