package domain;

import util.ValidateInput;

public class StringCalculator {

    public int add(String text) {
        String input = new ValidateInput(text).getYourInput();

        return Integer.parseInt(input);
    }
}
