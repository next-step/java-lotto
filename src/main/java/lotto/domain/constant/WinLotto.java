package lotto.domain.constant;

import java.util.Arrays;

public enum WinLotto {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final Integer hitNumber;
    private final Integer winningAmount;

    WinLotto(Integer hitNumber, Integer winningAmount) {
        this.hitNumber = hitNumber;
        this.winningAmount = winningAmount;
    }

    public static WinLotto toWinLotto(Integer hitNumber) {
        return Arrays.stream(values())
            .filter((winLotto) -> winLotto.hitNumber.equals(hitNumber))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getWinningAmount() {
        return winningAmount;
    }

}
