package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    private static final String REGEX = "[+-]?\\d*(\\.\\d+)?";

    private final List<Number> inputs;
    private Number result;

    public Numbers(List<Number> inputs) {
        this.inputs = inputs;
        this.result = new Number(0);
    }

    public Numbers(String inputs) {
        this.inputs = split(inputs);
        this.result = new Number(0);
    }

    public void sum() {
        int result = inputs.stream()
                .mapToInt(Number::getValue)
                .sum();

        this.result = new Number(result);
    }

    public Number result() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers = (Numbers) o;
        return Objects.equals(inputs, numbers.inputs) && Objects.equals(result, numbers.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs, result);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "inputs=" + inputs +
                ", result=" + result +
                '}';
    }

    private List<Number> split(String input) {
        List<String> splitInputs = StringUtils.split(input);

        return splitInputs.stream()
                .map(splitInput -> {
                    if (!isNumber(splitInput)) {
                        throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
                    }
                    return new Number(splitInput);
                })
                .collect(Collectors.toList());
    }

    private boolean isNumber(String splitInput) {
        return splitInput.matches(REGEX);
    }
}
