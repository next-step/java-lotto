package lotto.domain;

import lotto.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Number> numbers;

    public WinningNumbers(final String value) {
        this(StringUtils.split(value, ","));
    }

    public WinningNumbers(final List<String> values) {
        this.numbers = values.stream()
                .map(Number::new)
                .collect(Collectors.toList());
        validation(numbers);
    }

    public void validation(final List<Number> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }
}
