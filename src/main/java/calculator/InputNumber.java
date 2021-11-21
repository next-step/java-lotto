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

    public static InputNumber create(String input, Splitter splitter) {
        if (StringUtils.isNullOrEmpty(input)) {
            return new InputNumber();
        }

        return new InputNumber(
            Arrays.stream(splitter.split(input))
                .map(StringUtils::parsePositiveNumber)
                .collect(Collectors.toList()));
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
