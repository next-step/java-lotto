package lotto.domain.lotto;

import lotto.domain.number.LottoNumbers;

public class WinningLotto {

    private final LottoNumbers numbers;
    private final int bonusNumber;

    public WinningLotto(LottoNumbers numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchNumberCount(NormalLotto lotto) {
        return lotto.getNumbers()
            .matchCount(numbers);
    }

    public boolean matchBonusNumber(NormalLotto lotto) {
        return lotto.getNumbers()
            .contains(bonusNumber);
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
