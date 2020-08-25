package step1;

import java.util.Arrays;
import java.util.Scanner;

import static step1.UserInput.*;

public class ValidateInput {

    private String input;
    private String inputs[];

    public ValidateInput(String input) {
        this.input = validateSomeThing(input);
    }

    public String getInput() {
        return input;
    }

    String validateSomeThing(String input) {
        if (validateInputNull(input)) {
            input = STRING_ZERO;
            return input;
        }
        if (validateInputOneNumber(input)) {
            return input;
        }

        if (isCustomDelimiter(input)) {
            input += LINE_FEED + new Scanner(System.in).nextLine();
            return input;
        }
        inputs = input.split(DELIMITER);
        validateInputNegative(inputs);
        return input;
    }

    boolean validateInputNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean validateInputOneNumber(String input) {
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

    boolean isCustomDelimiter(String input) {
        if (input.substring(ZERO, TWO).equals("//")) {
            return true;
        }
        return false;
    }
}
