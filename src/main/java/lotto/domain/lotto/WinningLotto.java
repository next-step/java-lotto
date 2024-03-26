package lotto.domain.lotto;

import lotto.error.ErrorCode;

public class WinningLotto {
    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto numbers, LottoNumber bonusNumber) {
        assertNumbersNotDuplicated(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void assertNumbersNotDuplicated(Lotto numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBERS_DUPLICATED.message());
        }
    }

    public Lotto numbers() {
        return this.numbers;
    }

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }
}
