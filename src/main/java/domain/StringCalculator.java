package domain;

import util.ValidateInput;

public class StringCalculator {

    public int add(String text) {
        String input = new ValidateInput(text).getYourInput();
        Parser parser = new Parser(input);
        final int total = parser.splitStringToNumber().stream().mapToInt(Integer::intValue).sum();

        return total;
    }
}
