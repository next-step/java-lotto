package lotto.domain;

public class WinLotto {

    private final Lotto lotto;

    private final Number bonus;

    public WinLotto(Lotto lotto, Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto lotto() {
        return lotto;
    }

    public Number bonus() {
        return bonus;
    }

}
