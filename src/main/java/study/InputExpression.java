package study;

import java.util.Arrays;
import java.util.List;

public class InputExpression {
    private final String inputString;

    public InputExpression(String inputString) {
        this.inputString = inputString;
    }

    public List<String> split() {
        String[] tokens = inputString.split(",|:");
        return Arrays.asList(tokens);
    }
}
