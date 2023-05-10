package lotto.domain.constant;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int hitNumber;
    private final int winningAmount;

    LottoRank(Integer hitNumber, Integer winningAmount) {
        this.hitNumber = hitNumber;
        this.winningAmount = winningAmount;
    }

    public static LottoRank toWinLotto(Integer hitNumber) {
        return Arrays.stream(values())
            .filter((winLotto) -> winLotto.hitNumber == hitNumber)
            .findAny()
            .orElse(MISS);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getHitNumber() {
        return hitNumber;
    }

}
