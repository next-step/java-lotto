package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import utils.StringUtils;

public class CalNumbers {

    private final List<Integer> numbers;

    public CalNumbers() {
        this(Collections.emptyList());
    }

    public CalNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static CalNumbers create(String input, Splitter splitter) {
        if (StringUtils.isNullOrEmpty(input)) {
            return new CalNumbers();
        }

        return new CalNumbers(
            Arrays.stream(splitter.split(input))
                .map(StringUtils::parsePositiveNumber)
                .collect(Collectors.toList()));
    }

    public int sum() {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalNumbers that = (CalNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
