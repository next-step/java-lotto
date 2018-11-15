package lotto.domain;

import lotto.exceptions.InputFormatException;
import lotto.utils.StringParser;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private Lotto winningLottoNumber;
    private int bonusBall;

    public WinningLotto(Lotto lotto, int bonusBall) {
        this.winningLottoNumber = lotto;
        this.bonusBall = bonusBall;
        validationCheck(bonusBall);
    }

    private void validationCheck(int bonusBall) {
        if (winningLottoNumber.isBonusBallInLotto(bonusBall)) {
            throw new InputFormatException();
        }
    }

    public int getRankCount(Lotto lotto, int count) {
        for (LottoNo lottoNo : winningLottoNumber.getLottoNumbers()) {
            count = getCount(lotto, count, lottoNo.getLottoNumber());
        }

        return count;
    }

    private int getCount(Lotto lotto, int count, Integer number) {
        if (lotto.contains(number)) {
            count++;
        }

        return count;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
