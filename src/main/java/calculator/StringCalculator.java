package calculator;

import java.util.List;

public class StringCalculator {

    private List<Number> numbers;
    private Delimiter delimiter;

    public StringCalculator(String value) {
        delimiter = new Delimiter(value);
        this.numbers = delimiter.numbers(value);
    }

    public int add() {
        Number result = numbers.stream()
              .reduce((x, y) -> {
                  x.add(y);
                  return x;
              }).get();

        return result.getNumber();
    }
}
