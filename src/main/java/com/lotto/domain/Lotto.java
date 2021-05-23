package com.lotto.domain;

import java.util.TreeSet;

import static com.lotto.domain.LottoReward.generateReward;

public final class Lotto {

    public static final int UNIT_PRICE = 1000;
    public static final int LOTTO_COUNT = 6;

    private TreeSet<LottoNumber> lottoNumbers;

    public Lotto(TreeSet<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public TreeSet<LottoNumber> numbers() {
        return lottoNumbers;
    }

    public LottoReward reward(LottoWinningNumbers winningNumbers) {
        int sameCount = 0;
        for (LottoNumber number : lottoNumbers) {
            sameCount += addOneIfContainInWinningNumbers(winningNumbers, number);
        }
        return generateReward(sameCount);
    }

    private int addOneIfContainInWinningNumbers(LottoWinningNumbers winningNumbers, LottoNumber number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
