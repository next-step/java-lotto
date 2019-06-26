package com.java.lotto.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public enum LottoReward {

    MATCH_THREE(3, 5000, (count) -> count * 5000),
    MATCH_FOUR(4, 50000, (count) -> count * 50000),
    MATCH_FIVE(5, 1500000, (count) -> count * 1500000),
    MATCH_SIX(6, 2000000000, (count) -> count * 2000000000);

    Integer matchNumber;
    Integer lottoMoney;
    private UnaryOperator<Integer> expression;

    LottoReward(Integer matchNumber, Integer lottoMoney, UnaryOperator<Integer> expression) {
        this.matchNumber = matchNumber;
        this.lottoMoney = lottoMoney;
        this.expression = expression;
    }

    public int reward(int count) {
        return expression.apply(count);
    }

    public static LottoReward rewardCheck(int matchNumber) {
        return Arrays.stream(LottoReward.values())
                .filter(lottoReward -> lottoReward.matchNumber.equals(matchNumber))
                .findFirst()
                .get();
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public int getLottoMoney() {
        return this.lottoMoney;
    }
}
