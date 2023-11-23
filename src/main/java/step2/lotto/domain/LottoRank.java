package step2.lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    LOSE(0, 0),
    FIFTH(3, 5_000),
    FORTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int prizeAmount;

    LottoRank(int countOfMatch, int prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank valueOf(final int countOfMatch, final boolean matchBonus) {
        if (matchBonus && SECOND.matches(countOfMatch)) {
            return SECOND;
        }

        return Arrays.stream(LottoRank.values())
            .filter(value -> value.matches(countOfMatch))
            .findFirst()
            .orElse(LOSE);
    }

    private boolean matches(final int count) {
        return this.countOfMatch == count;
    }

    public long lottoRankTotalPrizeAmount(final int scoreCount) {
        return this.prizeAmount * scoreCount;
    }

}
