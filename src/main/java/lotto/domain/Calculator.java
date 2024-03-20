package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {
    THREE(5000) ,
    FOUR(50000) ,
    FIVE(1500000) ,
    SIX(2000000000);

    private final int winningMoney;
    Calculator(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public Integer calculate(int count) {
        return winningMoney * count;
    }
}
