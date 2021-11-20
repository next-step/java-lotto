package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputNumber {

    private final List<Integer> numbers;

    public InputNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static InputNumber create(String input) {
        String[] splitNums = input.split("[,:]");

        List<Integer> numbers = Arrays.stream(splitNums)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        return new InputNumber(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputNumber that = (InputNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
