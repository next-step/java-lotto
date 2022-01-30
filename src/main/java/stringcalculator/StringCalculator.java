package stringcalculator;

import java.util.List;

public class StringCalculator {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Separator separator = new Separator(userInput.getUserInput());

        List<String> userNumbers = separator.split();
        Number numbers = new Number(userNumbers);
    }
}
