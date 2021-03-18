package step1.domain;

import java.util.regex.Pattern;

public class Validator {

    public boolean isInputMadeOfValidElements(String userInput) {
        return Pattern.matches("[0-9,:]+", userInput);
    }
}
