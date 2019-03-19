package domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    First(6, 2000000000), Second(5, 1500000),
    Third(4, 50000), Fourth(3, 5000),
    None(-1, 0);

    private int matchCount;
    private long prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank calculate(int matchCount) {
        Optional<Rank> rank = Arrays.stream(Rank.values())
            .filter(r -> r.matchCount == matchCount)
            .findFirst();

        return rank.orElse(None);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
