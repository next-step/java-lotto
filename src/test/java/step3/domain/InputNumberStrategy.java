package step3.domain;

import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoStrategy;
import java.util.List;

public class InputNumberStrategy implements LottoStrategy {

    private final List<LottoNumber> numbers;

    public InputNumberStrategy(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> createNumbers() {
        return numbers;
    }
}
