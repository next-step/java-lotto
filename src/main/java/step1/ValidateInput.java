package step1;

import java.util.Arrays;
import java.util.Scanner;

import static step1.UserInput.*;

public class ValidateInput {

    private static String input;
    private String inputs[];

    public ValidateInput(String input) {
        validateSomeThing(input);
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    String validateSomeThing(String input) {
        if (validateInputNUll(input)) {
            System.out.println("g");
            input = STRING_ZERO;
            return input;
        }
        if (validateInputOneNumber(input)) {
            System.out.println("gg");
            return input;
        }

        if (isCustomDelimiter(input)) {
            System.out.println("ggg");
            input += LINE_FEED + new Scanner(System.in).nextLine();
            return input;
        }
        inputs = input.split(DELIMITER);
        validateInputNegative(inputs);
        return input;
    }

    boolean validateInputNUll(String input) {
        if (input == null || input.trim().isEmpty()) {
            this.input = STRING_ZERO;
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
        System.out.println("ggg");
        boolean isAllPositiveValue = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(element -> element >= ZERO);

        if (!isAllPositiveValue) {
            throw new RuntimeException("ERR!!!");
        }
    }

    private boolean isCustomDelimiter(String input) {
        if (input.substring(ZERO, TWO).equals("//")) {
            return true;
        }
        return false;
    }
}
