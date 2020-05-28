package com.lotto.domain;

import java.util.List;

public class LottoBonusBall {

    private Integer bonusBall;

    public LottoBonusBall(Integer bonusBall) {
        this.bonusBall = bonusBall;
    }

    public Integer getNumberOfMatchingWithBonusNumber(List<Integer> winningNumbers) {
        Integer total = 0;
        for (Integer winningNumber : winningNumbers) {
            total += increaseMatchingCount(winningNumber);
        }
        return total;
    }

    private Integer increaseMatchingCount(Integer winningNumber) {
        return winningNumber.equals(this.bonusBall) ? 1 : 0;
    }
}
