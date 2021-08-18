package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private static final int ADDED_WINNING_COUNT = 1;
    private static final int DEFAULT_MATCH_COUNT = 0;
    private final int matchCount;
    private final int cash;

    Rank(int matchCount, int cash) {
        this.matchCount = matchCount;
        this.cash = cash;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getCash() {
        return cash;
    }

    public static Rank find(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(winner -> winner.matchCount == matchCount)
                .findFirst().orElse(NONE);
    }

    public static Map<Rank, Integer> makeWinnerMap() {
        Map<Rank, Integer> map = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(winner -> map.put(winner, DEFAULT_MATCH_COUNT));
        return map;
    }

    public static Map<Rank, Integer> findWinningInfo(List<Integer> matchCounts) {
        Map<Rank, Integer> winnerMap = makeWinnerMap();

        for (Integer matchCount : matchCounts) {
            Rank rankInfo = Rank.find(matchCount);
            Integer currentCount = winnerMap.get(rankInfo);
            winnerMap.put(rankInfo, currentCount + ADDED_WINNING_COUNT);
        }
        return winnerMap;
    }

}