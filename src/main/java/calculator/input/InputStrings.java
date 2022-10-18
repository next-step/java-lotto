package calculator.input;

import java.util.Arrays;
import java.util.List;

public class InputStrings {

    String[] strings;

    public InputStrings(String[] strings) {
        this.strings = strings;
    }

    public List<String> getStrings() {
        return Arrays.asList(strings);
    }

    public static InputStrings from(String userInput) {
        if (userInput == null || userInput.equals("")) {
            throw new IllegalArgumentException("input cannot be empty");
        }
        return new InputStrings(userInput.split(" "));
    }
}
