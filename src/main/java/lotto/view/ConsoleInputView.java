package lotto.view;

import java.util.Scanner;

public class ConsoleInputView implements InputViewInterface {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String VALID_NUMBER_INPUT_MSG = "유효한 숫자를 입력해 주세요.";

    @Override
    public String[] getStringListInput(String prompt, String delimiter) {
        System.out.print(prompt);
        return scanner.nextLine().trim().split(delimiter);
    }

    @Override
    public int getNumberInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (isInteger(input)) return Integer.parseInt(input);
        System.out.println(VALID_NUMBER_INPUT_MSG);
        return getNumberInput(prompt);
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
