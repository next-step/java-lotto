package stringpluscalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomInputStrategy implements InputStrategy {

    private final String delimiter;
    private final String input;

    CustomInputStrategy(final String delimiter, final String input) {
        if (input.contains("-")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        this.delimiter = delimiter;
        this.input = input;
    }

    @Override
    public List<Integer> parse() {
        String[] operands = input.split(delimiter);
        List<Integer> parsedOpernads = new ArrayList<>();

        for (String operand : operands) {
            parsedOpernads.add(Integer.parseInt(operand));
        }

        return parsedOpernads;
    }

}
