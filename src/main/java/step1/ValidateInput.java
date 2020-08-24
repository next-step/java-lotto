package step1;

import java.util.Arrays;
import java.util.Scanner;

import static step1.UserInput.*;

public class ValidateInput {

    static String input;
    static String inputs[];

    public ValidateInput(String input) {
        this.input = input;
    }

    String validateSomeThing() {
        if (validateInputNUll()) {
            return input;
        }
        if (validateInputOneNumber()) {
            return input;
        }

        if (isCustomDelimiter()) {
            input += LINE_FEED + new Scanner(System.in).nextLine();
            return input;
        }
        inputs = input.split(DELIMITER);
        validateInputNegative(inputs);
        return input;
    }

    boolean validateInputNUll() {
        if (input == null || input.trim().isEmpty()) {
            this.input = STRING_ZERO;
            return true;
        }
        return false;
    }

    private boolean validateInputOneNumber() {
        if (input.length() == LENGTH_ONE) {
            return true;
        }
        return false;
    }

    void validateInputNegative(String[] inputs) {
        boolean isAllPositiveValue = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(element -> element >= ZERO);

        if (!isAllPositiveValue) {
            throw new RuntimeException("ERR!!!");
        }
    }

    private boolean isCustomDelimiter() {
        if (input.substring(ZERO, TWO).equals("//")) {
            return true;
        }
        return false;
    }
}
