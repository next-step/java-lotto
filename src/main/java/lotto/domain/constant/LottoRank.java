package lotto.domain.constant;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private final Integer hitNumber;
    private final Integer winningAmount;

    LottoRank(Integer hitNumber, Integer winningAmount) {
        this.hitNumber = hitNumber;
        this.winningAmount = winningAmount;
    }

    public static LottoRank toWinLotto(Integer hitNumber) {
        return Arrays.stream(values())
            .filter((winLotto) -> winLotto.hitNumber.equals(hitNumber))
            .findAny()
            .orElse(MISS);
    }

    public Integer getWinningAmount() {
        return winningAmount;
    }

}
