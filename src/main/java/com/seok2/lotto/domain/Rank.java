package com.seok2.lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, Money.of(2_000_000_000), "6개 일치 (2,000,000,000원)"),
    SECOND(5, Money.of(30_000_000), "5개 일치, 보너스 볼 일치(30,000,000원)"),
    THIRD(5, Money.of(1_500_000), "5개 일치 (1,500,000원)"),
    FOURTH(4, Money.of(50_000), "4개 일치 (50,000원)"),
    FIFTH(3, Money.of(5_000), "3개 일치 (5,000원)"),
    MISS(0, Money.of(0), "낙첨");

    private final int matches;
    private final Money reward;
    private final String description;


    Rank(int matches, Money reward, String description) {
        this.matches = matches;
        this.reward = reward;
        this.description = description;
    }

    public static Rank find(int matches, boolean isMatchBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.matches == matches)
            .filter(rank -> !rank.equals(SECOND) || isMatchBonus)
            .findFirst()
            .orElse(MISS);
    }

    public Money getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
