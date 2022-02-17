package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    ONE(2_000_000_000, 6, false),
    TWO(30_000_000, 5, true),
    THREE(1_500_000, 5, false),
    FOUR(50_000, 4, false),
    FIVE(5_000, 3, false),
    FAIL(0, 0, false);

    private final int winnerPrice;
    private final int normalMatcNumber;
    private final boolean bonusMatch;

    Ranking(int winnerPrice, int normalMatchNumber, boolean bonusMatch) {
        this.winnerPrice = winnerPrice;
        this.normalMatcNumber = normalMatchNumber;
        this.bonusMatch = bonusMatch;
    }

    public static Ranking of(int normalMatchCount, boolean bonusMatch) {
        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equalsFromResult(normalMatchCount, bonusMatch))
            .findFirst()
            .orElse(FAIL);
    }

    public static Ranking of(Lotto userNumbers,
        WinningLotto winningLotto) {
        int normalMatchCount = countNormalSuccessNumber(userNumbers,
            winningLotto.getLottoNumbers());
        boolean bonusMatch = countBonusNumber(userNumbers, winningLotto.getBonusNumber());

        return Ranking.of(normalMatchCount, bonusMatch);
    }

    private static int countNormalSuccessNumber(Lotto userNumbers, Lotto lotteryNumbers) {
        return lotteryNumbers.countSameNumber(userNumbers);
    }

    private static boolean countBonusNumber(Lotto userNumbers, LottoNumber bonusNum) {
        return userNumbers.contains(bonusNum);
    }

    private boolean equalsFromResult(int normalMatchNumber, boolean bonusMatch) {
        return this.normalMatcNumber == normalMatchNumber &&
            this.bonusMatch == bonusMatch;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public int getNormalMatcNumber() {
        return normalMatcNumber;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
