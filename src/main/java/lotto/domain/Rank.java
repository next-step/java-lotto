package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    INVALID(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank from(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(INVALID);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int countSameMatch(List<Rank> ranks) {
        return (int) ranks.stream()
                .filter(rank -> rank == this)
                .count();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static List<Integer> compareRank(List<Rank> lottoRanks) {
        List<Integer> result = new ArrayList<>();

        for (int i = Rank.values().length - 2; i >= 0; i--) {
            Rank rank = Rank.values()[i];
            int count = rank.countSameMatch(lottoRanks);

            result.add(rank.getMatchCount());
            result.add(rank.getPrize());
            result.add(count);
        }
        return result;
    }
}
