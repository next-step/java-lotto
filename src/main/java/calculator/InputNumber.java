package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import utils.StringUtils;

public class InputNumber {

    private final List<Integer> numbers;

    public InputNumber() {
        this(Collections.emptyList());
    }

    public InputNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static InputNumber create(String input) {

        if (StringUtils.isNullOrEmpty(input)) {
            return new InputNumber();
        }

        String[] splitNums = input.split("[,:]");

        List<Integer> numbers = Arrays.stream(splitNums)
            .map(StringUtils::parsePositiveNumber)
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
