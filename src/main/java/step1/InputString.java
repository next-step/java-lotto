package step1;

import java.util.ArrayList;
import java.util.List;

public class InputString {
    private final String input;
    private List<Integer> numbers = new ArrayList<>();

    public InputString(String input) {
        assertEmpty(input);
        this.input = input;
    }

    private void assertEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("문자열이 공백입니다.");
        }
    }

    public List<Integer> convertNumbers() {

        return numbers;
    }
}
