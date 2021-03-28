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

    public Rank containCount(Game prize, Bonus bonus) {
        long count = numbers.stream()
            .filter(prize.numbers::contains)
            .count();

        boolean matchBonus = numbers.stream()
            .anyMatch(bonus.ball()::equals);

        return Rank.valueOf(Long.valueOf(count).intValue(), matchBonus);
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
