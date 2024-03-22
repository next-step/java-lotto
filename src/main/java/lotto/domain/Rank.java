package lotto.domain;

import java.util.*;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 1500000),
    MISS(0, 0)
    ;

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    private static final Map<Integer, Rank> prizeMap = new HashMap<>();
    static {
        for (Rank prize : Rank.values()) {
            prizeMap.put(prize.matchCount, prize);
        }
    }

    public static List<Rank> getRanks() {
        return List.of(Rank.values());
    }

    public static Rank lookup(int matchCount) {
        return prizeMap.get(matchCount);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
