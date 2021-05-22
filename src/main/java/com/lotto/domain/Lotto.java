package com.lotto.domain;

import java.util.List;
import java.util.Set;

import static com.lotto.domain.LottoReward.*;

public final class Lotto {

    public static final int UNIT_PRICE = 1000;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> numbers() {
        return lottoNumbers;
    }

    public LottoReward reward(Set<Integer> winningNumbers) {
        int sameCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                sameCount++;
            }
        }
        return findReward(sameCount);
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
