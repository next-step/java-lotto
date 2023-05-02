package stringCalculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputOperationsAndNumber() {
        System.out.println("연산을 입력하세오");
        String inputString = scanner.nextLine();
        validInputString(inputString);
        return inputString.split(" ");
    }

    public static void validInputString(String inputString) {
        if(inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("다시 입력하세오");
        }
    }
}
