package stringpluscalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleInputStrategy implements InputStrategy {

    private static final String DELIMITER = "[,:]";
    private final String input;

    SimpleInputStrategy(final String input) {
        if (input.contains("-")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        this.input = input;
    }

    @Override
    public List<Integer> parse() {
        String[] operands = input.split(DELIMITER);
        List<Integer> parsedOpernads = new ArrayList<>();

        for (String operand : operands) {
            parsedOpernads.add(Integer.parseInt(operand));
        }

        return parsedOpernads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleInputStrategy that = (SimpleInputStrategy) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
