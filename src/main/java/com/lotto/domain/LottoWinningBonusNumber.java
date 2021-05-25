package com.lotto.domain;

import com.lotto.exception.LottoNumberFormatException;
import com.lotto.exception.LottoNumberOutOfBoundsException;

public class LottoWinningBonusNumber extends LottoNumber {

    private LottoWinningBonusNumber(int bonusNumber) {
        super(bonusNumber);
    }

    public static LottoWinningBonusNumber valueOf(int number) {
        validate(number);
        return LottoWinningBonusNumberCache.cache[number - 1];
    }

    private static void validate(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new LottoNumberOutOfBoundsException(number);
        }
    }

    public static LottoWinningBonusNumber valueOf(String sBonusNumber) {
        int number;
        try {
            number = Integer.parseInt(sBonusNumber);
        } catch (NumberFormatException exception) {
            throw new LottoNumberFormatException();
        }
        return valueOf(number);
    }

    private static class LottoWinningBonusNumberCache {
        static final LottoWinningBonusNumber[] cache = new LottoWinningBonusNumber[45];

        static {
            for (int i = LOTTO_START_NUMBER - 1; i < LOTTO_END_NUMBER; i++) {
                cache[i] = new LottoWinningBonusNumber(i + 1);
            }
        }

        private LottoWinningBonusNumberCache() {
        }
    }
}
