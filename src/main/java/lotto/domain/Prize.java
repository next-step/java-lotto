package lotto.domain;

import java.util.Arrays;

public enum Prize {
    ELSE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matching;

    private final int prize;

    Prize(Integer matching, Integer prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public static Prize findPrize(Integer matchingCount, WinningLotto winningLotto, boolean containBonus) {
        Prize prize = Arrays.asList(values()).stream()
                .filter(prizeEnum -> prizeEnum.matching == matchingCount)
                .findAny().orElse(Prize.ELSE);
        if (prize.matching == 5 && containBonus) {
            return Prize.SECOND;
        }
        if (prize.matching == 5 && !containBonus) {
            return Prize.THIRD;
        }
        return prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatching() {
        return matching;
    }
}
