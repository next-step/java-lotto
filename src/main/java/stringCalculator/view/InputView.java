package stringCalculator.view;

import java.util.Scanner;

public class InputView {

    public static String toCalculateString() {
        System.out.println("계산하고자 하는 내용을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("The Value should have at lest one value");
        }
    }

}
