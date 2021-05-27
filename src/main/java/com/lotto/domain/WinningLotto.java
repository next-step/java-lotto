package com.lotto.domain;

import com.lotto.exception.IllegalLottoCountException;
import com.lotto.exception.LottoNumberFormatException;
import com.lotto.exception.LottoNumberOutOfBoundsException;

import java.util.TreeSet;

import static com.lotto.domain.LottoReward.SECOND_BONUS;
import static com.lotto.domain.LottoReward.generateReward;

public final class WinningLotto extends Lotto {
    private LottoNumber bonusNumber;

    public WinningLotto(TreeSet<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createWinningLotto(Lotto winningLotto, String sBonusNumber)
            throws LottoNumberFormatException,
            LottoNumberOutOfBoundsException,
            IllegalLottoCountException {

        LottoNumber bonusNumber = castLottoNumber(sBonusNumber);

        return new WinningLotto(winningLotto.numbers(), bonusNumber);
    }

    public static LottoNumber castLottoNumber(String sNumber)
            throws LottoNumberOutOfBoundsException, LottoNumberFormatException {

        int number;
        try {
            number = Integer.parseInt(sNumber);
        } catch (NumberFormatException exception) {
            throw new LottoNumberFormatException();
        }

        return LottoNumber.valueOf(number);
    }

    public LottoReward reward(Lotto lotto) {
        int sameCount = 0;
        for (LottoNumber lottoNumber : lotto.numbers()) {
            sameCount += addOneIfContainInWinningNumbers(lottoNumber);
        }
        if (isSecond(sameCount) && contains(bonusNumber)) {
            return SECOND_BONUS;
        }
        return generateReward(sameCount);
    }

    private boolean isSecond(int sameCount) {
        return sameCount == SECOND_BONUS.sameCount();
    }

    private int addOneIfContainInWinningNumbers(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers().contains(number);
    }
}
