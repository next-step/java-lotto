package lotto.domain;

import static lotto.domain.LottoGameOptions.LOTTO_NUMBERS_FROM;
import static lotto.domain.LottoGameOptions.LOTTO_NUMBERS_TO;

public class LottoWinBonusNumber {
    private final int bonusNumber;

    public LottoWinBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBERS_FROM || bonusNumber > LOTTO_NUMBERS_TO) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(Integer lottoNum) {
        return bonusNumber == lottoNum;
    }
}
