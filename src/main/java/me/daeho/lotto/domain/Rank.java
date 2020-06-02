package me.daeho.lotto.domain;


import java.util.Arrays;

public enum Rank {
    FIRST(6,2000000000, false),
    SECOND(5, 3000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false)
    ;

    private final int count;
    private final int prize;
    private final boolean matchBonus;

    Rank(int count, int prize, boolean matchBonus) {
        this.count = count;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static Rank valueOf(int count, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(v -> count == v.count && matchBonus == v.matchBonus)
                .findAny()
                .orElse(NONE);
    }
}
