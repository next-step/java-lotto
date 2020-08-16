package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int DEFAULT_COUNT = 0;
    private final int countOfMatch;
    private final int prizeMoney;

    Ranking(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Ranking valueOfRanking(int countOfMatch) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public static Map<Ranking, Integer> valueMap() {
        Map<Ranking, Integer> rankingMap = new TreeMap<>(Comparator.reverseOrder());
        for (Ranking ranking : values()) {
            rankingMap.put(ranking, DEFAULT_COUNT);
        }
        return rankingMap;
    }
}
