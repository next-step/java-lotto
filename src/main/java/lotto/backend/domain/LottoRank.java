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

    private static final Map<Matching, LottoRank> CACHED_BY_MATCHING = new HashMap<>();
    private static final Map<Integer, Boolean> CACHED_BY_HAS_BONUS = new HashMap<>();

    static {
        for (LottoRank rank : LottoRank.values()) {
            CACHED_BY_MATCHING.put(new Matching(rank.countOfMatch, rank.hasBonus), rank);
            CACHED_BY_HAS_BONUS.put(rank.countOfMatch, rank.hasBonus);
        }
    }

    private final int countOfMatch;
    private final int moneyPrize;
    private final boolean hasBonus;

    LottoRank(int countOfMatch, int moneyPrize, boolean hasBonus) {
        this.countOfMatch = countOfMatch;
        this.moneyPrize = moneyPrize;
        this.hasBonus = hasBonus;
    }

    public static LottoRank of(Matching match) {
        return CACHED_BY_MATCHING.getOrDefault(match, LottoRank.NOTHING);
    }

    public static boolean hasBonusNumber(int countOfMatch) {
        return CACHED_BY_HAS_BONUS.getOrDefault(countOfMatch, false);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getMoneyPrize() {
        return moneyPrize;
    }

    public boolean HasBonus() {
        return hasBonus;
    }
}
