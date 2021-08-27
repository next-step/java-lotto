package lotto.domain;

import java.util.*;

public class LottoPaper {

    public static final int MATCH_COUNT = 1;
    public static final int NON_MATCH_COUNT = 0;
    private Set<Integer> lottoNumber;

    public LottoPaper(RandomNumber lottoNumberStragey) {
        lottoNumber = lottoNumberStragey.getLottoNumber();
    }

    public Set<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public int checkMatchNumberCount(Set<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : winningNumbers) {
            matchCount += containCheck(number);
        }
        return matchCount;
    }

    private int containCheck(int winningNumber) {
        return lottoNumber.contains(winningNumber) ? MATCH_COUNT : NON_MATCH_COUNT;
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

}
