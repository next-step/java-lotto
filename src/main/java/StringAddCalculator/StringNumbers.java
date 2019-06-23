package StringAddCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringNumbers {

    private List<StringNumber> numbers;

    public StringNumbers(String[] numbers) {
        this.numbers = buildList(numbers);
    }

    public StringNumber sum() {
        return numbers.stream()
                .reduce((number1, number2) -> number1.add(number2))
                .orElseThrow(RuntimeException::new);
    }

    private List<StringNumber> buildList(String[] numbers) {
        return Arrays.asList(numbers).stream()
                .map(number -> new StringNumber(number))
                .collect(Collectors.toList());
    }
}
