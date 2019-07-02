package com.java.lotto.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public enum LottoReward {

    MATCH_THREE(3, 5_000, (count) -> count * 5_000),
    MATCH_FOUR(4, 50_000, (count) -> count * 50_000),
    MATCH_FIVE(5, 1_500_000, (count) -> count * 1_500_000),
    MATCH_FIVE_BONUS(5, 30_000_000, (count) -> count * 30_000_000),
    MATCH_SIX(6, 2_000_000_000, (count) -> count * 2_000_000_000);

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
