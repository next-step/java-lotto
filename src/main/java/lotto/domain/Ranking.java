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

    public static Ranking getRanking(int normalSuccessCount, int bonusSuccessCount) {
        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equalsFromResult(normalSuccessCount, bonusSuccessCount))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean equalsFromResult(int normalSuccessCount, int bonusSuccessCount) {
        return this.normalSuccessNum == normalSuccessCount &&
            this.bonusSuccessNum == bonusSuccessCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public int getNormalSuccessNum() {
        return normalSuccessNum;
    }

    public int getBonusSuccessNum() {
        return bonusSuccessNum;
    }

    @Override
    public String toString() {
        int matchNum = normalSuccessNum + bonusSuccessNum;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchNum).append("개 일치");

        if (this.bonusSuccessNum > 0) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(").append(winnerPrice).append("원)");
        return stringBuilder.toString();
    }
}
