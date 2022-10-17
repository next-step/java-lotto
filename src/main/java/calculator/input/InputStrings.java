package calculator.input;

import java.util.Arrays;
import java.util.stream.Stream;

public class InputStrings {

    String[] strings;

    public InputStrings(String[] strings) {
        this.strings = strings;
    }

    public Stream<String> getStream() {
        return Arrays.stream(strings.clone());
    }

    public static InputStrings from(String userInput) {
        if (userInput == null || userInput.equals("")) throw new IllegalArgumentException("input cannot be empty");
        return new InputStrings(userInput.split(" "));
    }
}
