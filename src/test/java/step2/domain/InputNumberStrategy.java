package step2.domain;

import step2.domain.lotto.LottoStrategy;
import java.util.List;

public class InputNumberStrategy implements LottoStrategy {

    private final List<Integer> numbers;

    public InputNumberStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> createNumbers() {
        return numbers;
    }
}
