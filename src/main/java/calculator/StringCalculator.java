package calculator;

import java.util.List;

public class StringCalculator {

    public static int add(String expression) {
        List<Number> numbers = getNumbers(expression);
        return add(numbers);
    }

    private static List<Number> getNumbers(String expression) {
        Delimiter delimiter = new Delimiter(expression);
        return delimiter.numbers(expression);
    }

    private static int add(List<Number> numbers) {
        return numbers.stream()
              .reduce((x, y) -> {
                    x.add(y);
                    return x;
              }).get().getNumber();
    }
}
