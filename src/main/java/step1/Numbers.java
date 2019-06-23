package step1;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(List<String> tokens) {
        return new Numbers(convertNumbers(tokens));
    }

    private static List<Number> convertNumbers(List<String> tokens) {
        return tokens.stream()
                     .map(Number::new)
                     .collect(Collectors.toList());
    }

    public int getTotalSum() {
        return numbers.stream()
                      .mapToInt(Number::getNumber)
                      .sum();
    }

}
