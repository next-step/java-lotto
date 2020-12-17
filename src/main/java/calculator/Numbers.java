package calculator;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

        return mapNumbers(strNumbers);
    }

    private static boolean isBlank(String source) {
        return Objects.isNull(source) || source.isEmpty();
    }

    private static Numbers mapNumbers(List<String> strNumbers) {
        return strNumbers.stream()
                    .map(Number::of)
                    .collect(collectingAndThen(toList(), Numbers::new));
    }

    public int sum() {
        return numbers.stream()
                .reduce(0, (partialResult, number) -> number.sum(partialResult), Integer::sum);
    }
}
