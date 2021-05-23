package com.lotto.domain;

import java.util.Set;
import java.util.TreeSet;

import static com.lotto.domain.LottoReward.*;

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

    public LottoReward reward(Set<Integer> winningNumbers) {
        int sameCount = 0;
        for (LottoNumber number : lottoNumbers) {
            sameCount += addOneIfContains(winningNumbers, number.number());
        }
        return findReward(sameCount);
    }

    private int addOneIfContains(Set<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private LottoReward findReward(int sameCount) {
        switch (sameCount) {
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            default:
                return NOTHING;
        }
    }
}
