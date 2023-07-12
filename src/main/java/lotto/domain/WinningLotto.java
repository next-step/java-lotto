package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final Ball bonus;

    public WinningLotto(final Lotto lotto, final Ball bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
