package Lotto.view.input;

import Lotto.view.message.Message;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputView implements InputViewInterface {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    @Override
    public int getNumberInput() {
        String input = scanner.nextLine().trim();
        if (isInteger(input)) return Integer.parseInt(input);
        System.out.println(Message.VALID_NUMBER_INPUT);
        return getNumberInput();
    }

    @Override
    public int[] getNumberListInput() {
        String input = scanner.nextLine().trim();
        String[] tokens = Arrays.stream(input.split(DELIMITER)).map(String::trim).toArray(String[]::new);
        if (Arrays.stream(tokens).allMatch(this::isInteger)) {
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(Message.VALID_NUMBER_INPUT);
        return getNumberListInput();
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
