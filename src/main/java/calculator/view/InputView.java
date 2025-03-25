package calculator.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String REGEX = "[0-9+\\-*/\\s]+";

    public String input() {
        String text = scanner.nextLine();
        validateNotBlank(text);
        validateRegEx(text);
        return text;
    }

    private void validateNotBlank(String text) {
        if(text == null || text.isBlank())
            throw new IllegalArgumentException("text should be not blank");
    }

    private void validateRegEx(String text) {
         if(!Pattern.matches(REGEX, text))
             throw new IllegalArgumentException("text should be consist of number and operators(+,-,*,/).");
    }

}
