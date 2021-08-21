package step3.util;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2_000_000_000) { public boolean apply(int countOfMatch, boolean matchBonus) {return countOfMatch == 6;}},
    SECOND(30_000_000) { public boolean apply(int countOfMatch, boolean matchBonus) {return countOfMatch == 5 && matchBonus;}},
    THIRD(1_500_000) { public boolean apply(int countOfMatch, boolean matchBonus) {return countOfMatch == 5 && !matchBonus;}},
    FOURTH(50_000) { public boolean apply(int countOfMatch, boolean matchBonus) {return countOfMatch == 4;}},
    FIFTH(5_000) { public boolean apply(int countOfMatch, boolean matchBonus) {return countOfMatch == 3;}},
    MISS(0) { public boolean apply(int countOfMatch, boolean matchBonus) {return countOfMatch == 0;}};

    private int winningMoney;

    private Rank(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public abstract boolean apply(int countOfMatch, boolean matchBonus);

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.apply(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}