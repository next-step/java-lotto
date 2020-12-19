package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumber {

    private final String input;

    public InputNumber(String input) {
        this.input = input;
    }

    public boolean isEmpty() {
        return input == null || input.trim().isEmpty();
    }

    public int getNumber() {
        return Integer.parseInt(input);
    }

    public List<Integer> split() {
        return Arrays.stream(input.split("[,:]")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
    }


    public boolean isOneLength() {
        return input.length()==1;
    }
}
