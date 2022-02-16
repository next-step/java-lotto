package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    ONE(2000000000, 6, false),
    TWO(30000000, 5, true),
    THREE(1500000, 5, false),
    FOUR(50000, 4, false),
    FIVE(5000, 3, false),
    FAIL(0, 0, false);

    private final int winnerPrice;
    private final int normalSuccessNum;
    private final boolean bonusSuccess;

    Ranking(int winnerPrice, int normalSuccessNum, boolean bonusSuccess) {
        this.winnerPrice = winnerPrice;
        this.normalSuccessNum = normalSuccessNum;
        this.bonusSuccess = bonusSuccess;
    }

    public static Ranking of(int normalSuccessCount, boolean bonusSuccess) {
        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equalsFromResult(normalSuccessCount, bonusSuccess))
            .findFirst()
            .orElse(FAIL);
    }

    public static Ranking of(Lotto userNumbers,
        WinningLotto winningLotto) {
        int normalSuccessCount = countNormalSuccessNumber(userNumbers,
            winningLotto.getLottoNumbers());
        boolean bonusSuccess = countBonusNumber(userNumbers, winningLotto.getBonusNumber());

        return Ranking.of(normalSuccessCount, bonusSuccess);
    }

    private static int countNormalSuccessNumber(Lotto userNumbers, Lotto lotteryNumbers) {
        return lotteryNumbers.countSameNumber(userNumbers);
    }

    private static boolean countBonusNumber(Lotto userNumbers, LottoNumber bonusNum) {
        return userNumbers.contains(bonusNum);
    }

    private boolean equalsFromResult(int normalSuccessCount, boolean bonusSuccess) {
        return this.normalSuccessNum == normalSuccessCount &&
            this.bonusSuccess == bonusSuccess;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public int getNormalSuccessNum() {
        return normalSuccessNum;
    }

    public boolean getBonusSuccess() {
        return bonusSuccess;
    }
}
