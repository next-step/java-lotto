package step1;

import java.util.Scanner;

public class UserInput {
    static final int ZERO = 0;
    static final int LENGTH_ONE = 1;
    static final int TWO = 2;

    static final String DELIMITER = ",|:";
    static final String STRING_ZERO = "0";
    static final String LINE_FEED = "\n";

    static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ValidateInput validate = new ValidateInput(input);
        String validateResult = validate.validateSomeThing();

        return validateResult;
    }
}
