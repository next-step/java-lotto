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
}
