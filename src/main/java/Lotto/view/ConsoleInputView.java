package Lotto.view;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputView implements InputViewInterface{
    private static final Scanner scanner = new Scanner(System.in);
    public static final String VALID_NUMBER_INPUT_MSG = "유효한 숫자를 입력해 주세요.";

    @Override
    public int getNumberInput() {
        String input = scanner.nextLine().trim();
        if (isInteger(input)) return Integer.parseInt(input);
        System.out.println(VALID_NUMBER_INPUT_MSG);
        return getNumberInput();
    }

    @Override
    public int[] getNumberListInput(String delimiter) {
        String input = scanner.nextLine().trim();
        String[] tokens = Arrays.stream(input.split(delimiter)).map(String::trim).toArray(String[]::new);
        if (Arrays.stream(tokens).allMatch(this::isInteger)) {
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(VALID_NUMBER_INPUT_MSG);
        return getNumberListInput(delimiter);
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
