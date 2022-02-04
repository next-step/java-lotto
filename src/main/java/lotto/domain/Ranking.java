package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    ONE(2000000000, 6, 0),
    TWO(30000000, 5, 1),
    THREE(1500000, 5, 0),
    FOUR(50000, 4, 0),
    FIVE(5000, 3, 0),
    FAIL(0, 0, 0);

    private final int winnerPrice;
    private final int normalSuccessNum;
    private final int bonusSuccessNum;

    Ranking(int winnerPrice, int normalSuccessNum, int bonusSuccessNum) {
        this.winnerPrice = winnerPrice;
        this.normalSuccessNum = normalSuccessNum;
        this.bonusSuccessNum = bonusSuccessNum;
    }

    public static double getRewardRate(LottoCountResult lottoResult, int userBuyPrice) {
        Ranking ranking = getRanking(lottoResult);
        return (double) userBuyPrice / ranking.winnerPrice;
    }

    public static Ranking getRanking(LottoCountResult lottoResult) {
        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equalsFromResult(lottoResult))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean equalsFromResult(LottoCountResult lottoResult) {
        return this.normalSuccessNum == lottoResult.getNormalSuccessCount() &&
            this.bonusSuccessNum == lottoResult.getBonusSuccessCount();
    }
}
