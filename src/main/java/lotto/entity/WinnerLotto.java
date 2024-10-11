package lotto.entity;

import java.util.Objects;

public class WinnerLotto {
    private final PrizeMoney prizeMoney;
    private final Lotto lotto;

    public WinnerLotto(PrizeMoney prizeMoney, Lotto lotto) {
        this.prizeMoney = prizeMoney;
        this.lotto = lotto;
    }

    public boolean isWinner() {
        return prizeMoney.isWinner();
    }
}
