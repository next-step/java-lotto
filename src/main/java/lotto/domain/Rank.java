package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    SECOND_BONUS(5, 30_000_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private int matchCount;
    private int prize;

    private Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank getRank(int matchCount, boolean bonus) {
        if(bonus) {
            return Rank.SECOND_BONUS;
        }

        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.matchCount == matchCount)
                .findAny()
                .orElse(NOTHING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Map<Rank, Integer> getInitRankInfo() {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));
    }

}
