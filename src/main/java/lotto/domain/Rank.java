package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private int matchCount;
    private int prize;
    private static final HashMap<Rank, Integer> matchResult = new HashMap<>() {{
        put(Rank.FIRST, 0);
        put(Rank.SECOND, 0);
        put(Rank.THIRD, 0);
        put(Rank.FOURTH, 0);
        put(Rank.FIFTH, 0);
    }};

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == Rank.SECOND.matchCount && matchBonus) {
            return SECOND;
        }
        if (matchCount < Rank.FIFTH.matchCount) {
            return NONE;
        }

        return matchLottoPrize(matchCount);
    }

    private static Rank matchLottoPrize(int matchCount) {
        return Arrays.stream(values())
                .filter((rank) -> rank.matchCount == matchCount && rank != SECOND)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("로또는 적어도 3개 이상 일치해야 합니다."));
    }

    public static void putMatchResult(Rank rank) {
        if (rank == Rank.NONE) {
            return;
        }
        matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
    }

    public static HashMap<Rank, Integer> getMatchResult() {
        return matchResult;
    }

}
