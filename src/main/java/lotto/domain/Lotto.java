package lotto.domain;

import java.util.List;

import static lotto.domain.LottoGenerator.toLotto;
import static lotto.domain.LottoGenerator.validateSize;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto() {
        this(createLotto());
    }

    public Lotto(String numbers) {
        this(toLotto(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private static List<LottoNumber> createLotto() {
        return LottoGenerator.generate();
    }
}
