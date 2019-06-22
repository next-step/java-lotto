package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;

import java.util.Arrays;

public enum LottoPrize {

    LOSE(Env.LOSE_COUNT_OF_MATCH, Env.LOSE_PRIZE_MONEY),
    FOURTH(Env.FOURTH_COUNT_OF_MATCH,  Env.FOURTH_PRIZE_MONEY),
    THIRD(Env.THIRD_COUNT_OF_MATCH, Env.THIRD_PRIZE_MONEY),
    SECOND(Env.SECOND_COUNT_OF_MATCH, Env.SECOND_PRIZE_MONEY),
    JACKPOT(Env.JACKPOT_COUNT_OF_MATCH, Env.JACKPOT_PRIZE_MONEY);

    private final int countOfMatch;
    private final long prizeMoney;

    LottoPrize(final int countOfMatch, final int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    long getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize valueOf(final int countOfMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(LOSE);
    }
}
