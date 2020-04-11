package lotto.domain.rank;


import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    ZERO(LottoTier.of(0, false), 0),
    ONE(LottoTier.of(1, false), 0),
    TWO(LottoTier.of(2, false), 0),
    THREE(LottoTier.of(3, false), 5_000),
    FOUR(LottoTier.of(4, false), 50_000),
    FIVE(LottoTier.of(5, false), 1_500_000),
    FIVE_BONUS(LottoTier.of(5, true), 300_000_000),
    SIX(LottoTier.of(6, false), 2_000_000_000);

    private static Map<LottoTier, LottoRank> levels = new HashMap<>();

    static {
        levels.put(LottoTier.of(0, false), ZERO);
        levels.put(LottoTier.of(1, false), ONE);
        levels.put(LottoTier.of(2, false), TWO);
        levels.put(LottoTier.of(3, false), THREE);
        levels.put(LottoTier.of(4, false), FOUR);
        levels.put(LottoTier.of(5, false), FIVE);
        levels.put(LottoTier.of(5, true), FIVE_BONUS);
        levels.put(LottoTier.of(6, false), SIX);
    }

    private final LottoTier lottoTier;
    private final int winningPrize;

    LottoRank(LottoTier lottoTier, int winningPrize) {
        this.lottoTier = lottoTier;
        this.winningPrize = winningPrize;
    }

    public static LottoRank of(LottoTier lottoTier) {
        return levels.get(lottoTier);
    }

    public int getMatchCount() {
        return lottoTier.getMatchCount();
    }

    public int getWinningPrize() {
        return winningPrize;
    }

}
