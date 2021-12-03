package step1.calculator;

import java.util.Optional;

/**
 * .
 */
public class Number {

    private final int number;

    public Number(String userInput) {
        this.number = checkString(userInput);
    }

    private int checkString(String string) {
        try {
            int num = Integer.parseInt(string);
            if (num < 0) {
                throw new RuntimeException();
            }
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public int getNumber() {
        return number;
    }
}
