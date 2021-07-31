package lotto.domain.lotto;

import lotto.domain.number.LottoNumbers;

public class NormalLotto {

    private final LottoNumbers numbers;

    public NormalLotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
