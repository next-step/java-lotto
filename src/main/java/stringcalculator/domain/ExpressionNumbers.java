package stringcalculator.domain;

import stringcalculator.domain.vo.Number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionNumbers {
    private List<Number> numbers;

    public ExpressionNumbers(List<String> stringNumbers) {
        this.numbers = Collections.unmodifiableList(createNumbers(stringNumbers));
    }

    public Number sumAllNumbers() {
        return this.numbers.stream()
                .reduce(Number::sum)
                .orElseThrow(() -> new IllegalStateException("계산할 값이 존재하지않습니다."));
    }

    private List<Number> createNumbers(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(Number::stringToNumber)
                .collect(Collectors.toList());
    }
}
