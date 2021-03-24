package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Number> numbers;

    public Game(int length) {
        this.numbers = init(length);
    }

    public Game(List<Integer> numbers) {
        this.numbers = init(numbers);
    }

    public Integer containCount(Game prize) {
        long count = numbers.stream()
            .filter(prize.numbers::contains)
            .count();

        return Long.valueOf(count).intValue();
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    private List<Number> init(int length) {
        return LottoGenerator.generateLotto(length);
    }

    private List<Number> init(List<Integer> numbers) {
        return numbers.stream()
            .map(Number::new)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "[ " +
            numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(","))
            + " ]";
    }
}
