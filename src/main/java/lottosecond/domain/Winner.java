package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;

import java.util.Arrays;

public enum Winner implements Comparable<Winner> {

    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0,  1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000);

    private final int normalNumberMatchCount;
    private final int bonusNumberMatchCount;
    private final long price;

    Winner(int normalNumberMatchCount, int bonusNumberMatchCount, int price) {
        this.normalNumberMatchCount = normalNumberMatchCount;
        this.bonusNumberMatchCount = bonusNumberMatchCount;
        this.price = price;
    }

    public static Winner calculateWinner(Lotto myLotto, WinningLottoAndBonusBall winningLottoAndBonusBall) {
        int matchCount = myLotto.matchNumberCount(winningLottoAndBonusBall.getLotto());
        int matchBonusBallCount = 0;

        if (matchCount == 5) {
            matchBonusBallCount = myLotto.matchBonusBallNumberCount(winningLottoAndBonusBall.getBonusBall());
        }

        int finalMatchBonusBallCount = matchBonusBallCount;
        return Arrays.stream(Winner.values())
                .filter(winner -> winner.normalNumberMatchCount == matchCount && winner.bonusNumberMatchCount == finalMatchBonusBallCount)
                .findFirst()
                .orElse(null);
    }

    public long getPrice() {
        return price;
    }

    public int getNormalNumberMatchCount() {
        return normalNumberMatchCount;
    }
}
