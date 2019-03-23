package domain;

import view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    protected List<Number> numbers;

    public Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        this(split(numbers)
                .map(v -> (new Number(toInt(v))))
                .collect(Collectors.toList()));
    }

    private static int toInt(String v) {
        return Integer.parseInt(v);
    }

    private static Stream<String> split(String number) {
        return Arrays.stream(number.split(", "));
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public LottoView toView() {
        return new LottoView(numbers);
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }
}
