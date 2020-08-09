package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRanking {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, LottoRanking> BY_COUNT_OF_MATCH = new HashMap<>();

    static {
        for (LottoRanking ranking : values()) {
            BY_COUNT_OF_MATCH.put(ranking.countOfMatch, ranking);
        }
    }

    private final int countOfMatch;
    private final int prize;

    LottoRanking(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRanking valueOfCount(int countOfMatch) {
        return BY_COUNT_OF_MATCH.get(countOfMatch);
    }
}
