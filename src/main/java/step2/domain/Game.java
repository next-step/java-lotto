package step2.domain;

import java.util.List;

public class Game {

    private final List<Number> numbers;

    public Game(int length) {
        this.numbers = this.init(length);
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
}
