package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(final Lotto lotto, final int bonus) {

        if (lotto == null || bonus == 0) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

}
