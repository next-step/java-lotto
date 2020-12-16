package calculator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Numbers of(String source) {
        if (isBlank(source)) {
            return new Numbers(Collections.emptyList());
        }

        StringExpression stringExpression = StringExpression.of(source);
        List<String> strNumbers = stringExpression.split();

        return new Numbers(mapNumbers(strNumbers));
    }

    private static boolean isBlank(String source) {
        return Objects.isNull(source) || source.isEmpty();
    }

    private static List<Number> mapNumbers(List<String> strNumbers) {
        return strNumbers.stream()
                    .map(Number::of)
                    .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .reduce(0, (partialResult, number) -> number.sum(partialResult), Integer::sum);
    }
}
