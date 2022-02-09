package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    FAIL(0, 0, false);

    private final int winnerPrice;
    private final int normalNumberMatchCount;
    private final boolean isBonusNumberMatch;

    Ranking(final int winnerPrice, final int normalNumberMatchCount,
        final boolean isBonusNumberMatch) {
        this.winnerPrice = winnerPrice;
        this.normalNumberMatchCount = normalNumberMatchCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
    }

    public static Ranking judgeRanking(LottoResult lottoResult) {
        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equals(lottoResult))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean equals(LottoResult lottoResult) {
        return this.normalNumberMatchCount == lottoResult.getNormalNumberMatchCount() &&
            this.isBonusNumberMatch == lottoResult.getBonusNumberMatch();
    }

    public int multiplyCountAndWinnerPrice(final int count) {
        return winnerPrice * count;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public int getNormalNumberMatchCount() {
        return normalNumberMatchCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public boolean isBonusNumberMatch() {
        return isBonusNumberMatch;
    }
}
