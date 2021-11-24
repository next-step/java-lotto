package step2.domain;

import step2.validator.StringNumberValidator;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;

    private WinningLotto() {
    }

    private WinningLotto(String[] numbers) {
        this.lotto = Lotto.of(numbers);
    }

    public static WinningLotto create(String numbers) {
        return new WinningLotto(StringNumberValidator.splitNumbers(numbers));
    }

    public Lotto getLotto() {
        return lotto;
    }

    public List<Number> getLottoNumbers() {
        return lotto.getLottoNumbers();
    }
}
