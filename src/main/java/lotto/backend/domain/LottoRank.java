package lotto.backend.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

    NOTHING(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 3_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private static final Map<Integer, LottoRank> CACHED_BY_MATCHING = new HashMap<>();

    static {
        for (LottoRank rank : LottoRank.values()) {
            CACHED_BY_MATCHING.put(rank.countOfMatch, rank);
        }
    }

    private final int countOfMatch;
    private final int moneyPrize;
    private final boolean hasBonusNumber;

    LottoRank(int countOfMatch, int moneyPrize, boolean hasBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.moneyPrize = moneyPrize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRank valueOf(Matching matching) {
        if (matching.countOfMatch() == 5) {
            return matching.hasBonusNumber() ? SECOND : THIRD;
        }
        return CACHED_BY_MATCHING.getOrDefault(matching.countOfMatch(), NOTHING);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getMoneyPrize() {
        return moneyPrize;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
