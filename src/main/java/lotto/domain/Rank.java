package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private static final int SECOND_RANK_MATCH_COUNT = 5;

    private final int matchCount;
    private final boolean matchBonus;
    private final int winningMoney;

    Rank(int matchCount, boolean matchBonus, int winningMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public static Rank of(int matchCount, boolean matchBonus) {

        if (matchCount == SECOND_RANK_MATCH_COUNT && matchBonus) {
            return SECOND;
        }

        Optional<Rank> maybe = Arrays.stream(values())
                .filter(rank -> matchCount == rank.matchCount && !rank.matchBonus)
                .findAny();

        return maybe.orElse(Rank.MISS);
    }

    public int getMoney() {
        return winningMoney;
    }
}
