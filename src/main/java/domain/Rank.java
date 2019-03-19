package domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    First(6, 2000000000L), Second(5, 1500000L),
    Third(4, 50000L), Fourth(3, 5000L),
    None(-1, 0L);

    private Integer matchCount;
    private Long prizeMoney;

    Rank(Integer matchCount, Long prizeMoney) {
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
