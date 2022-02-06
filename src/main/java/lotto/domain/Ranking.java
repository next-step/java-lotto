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
    private final int normalSuccessNumber;
    private final boolean bonusSuccessNumber;

    Ranking(final int winnerPrice, final int normalSuccessNumber, final boolean bonusSuccessNumber) {
        this.winnerPrice = winnerPrice;
        this.normalSuccessNumber = normalSuccessNumber;
        this.bonusSuccessNumber = bonusSuccessNumber;
    }

    public static Ranking judgeRanking(LottoResult lottoResult) {
        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equals(lottoResult))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean equals(LottoResult lottoResult) {
        return this.normalSuccessNumber == lottoResult.getNormalSuccessCount() &&
            this.bonusSuccessNumber == lottoResult.getBonusSuccessCount();
    }

    public int multiplyCountAndWinnerPrice(final int count) {
        return winnerPrice * count;
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }

    public int getNormalSuccessNumber() {
        return normalSuccessNumber;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }
}
