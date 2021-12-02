package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> inputs;
    private int result = 0;

    public Numbers(List<Number> inputs) {
        this.inputs = inputs;
    }

    public Numbers(String inputs) {
        this.inputs = split(inputs);
    }

    public void sum() {
        inputs.forEach(number -> result += number.getValue());
    }

    public int result() {
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
        return result == numbers.result && Objects.equals(inputs, numbers.inputs);
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
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
