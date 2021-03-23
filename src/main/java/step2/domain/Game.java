package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Number> numbers;

    public Game(int length) {
        this.numbers = this.init(length);
    }

    public Game(List<Integer> lastPrize) {
        this.numbers = initLastPrize(lastPrize);
    }

    public Long containCount(Game lastPrize) {
        return numbers.stream()
            .filter(lastPrize.numbers::contains)
            .count();
    }

    public int size() {
        return numbers.size();
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    private List<Number> init(int length) {
        return LottoGenerator.generateLotto(length);
    }

    private List<Number> initLastPrize(List<Integer> lastPrize) {
        return lastPrize.stream()
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
