package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private final List<String> elements;
    public StringCalculator(String input) {
        this.elements = split(checkBlank(input));
    }

    private String checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 빈칸입니다.");
        }
        return input;
    }
    private List<String> split(String input) {
        return Arrays.asList(input.split(" "));
    }

    public List<String> getElements() {
        return this.elements;
    }
}
