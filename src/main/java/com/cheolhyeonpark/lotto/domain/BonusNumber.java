package com.cheolhyeonpark.lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(int number) {
        return bonusNumber == number;
    }
}
