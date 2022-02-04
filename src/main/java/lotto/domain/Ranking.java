package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5, 0),
    FOURTH(50000, 4, 0),
    FIFTH(5000, 3, 0),
    FAIL(0, 0, 0);

    private final int winnerPrice;
    private final int normalSuccessNumber;
    private final int bonusSuccessNumber;

    Ranking(int winnerPrice, int normalSuccessNumber, int bonusSuccessNumber) {
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
