package lotto.domain.matcher;

public class LottoTier {
    private final int matchCount;
    private final boolean bonus;

    private LottoTier(int matchCount, boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public static LottoTier of(int matchCount, boolean bonus) {
        return new LottoTier(matchCount, bonus);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }
}
