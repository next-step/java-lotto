package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public enum LottoRanking {

    NOT_MATCH(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, LottoRanking> BY_COUNT_OF_MATCH = new HashMap<>();

    static {
        for (LottoRanking ranking : values()) {
            if (ranking != BONUS && ranking != NOT_MATCH) {
                BY_COUNT_OF_MATCH.put(ranking.countOfMatch, ranking);
            }
        }
    }

    private final int countOfMatch;
    private final int prize;

    LottoRanking(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int countOfMatch() {
        return countOfMatch;
    }

    public int prize() {
        return prize;
    }

    public static LottoRanking valueOf(int countOfMatch, Supplier<Boolean> bonusSupplier) {
        LottoRanking ranking = BY_COUNT_OF_MATCH.get(countOfMatch);
        if (ranking == null) {
            return NOT_MATCH;
        }
        return ranking == SECOND && bonusSupplier.get()
            ? BONUS
            : ranking;
    }
}
