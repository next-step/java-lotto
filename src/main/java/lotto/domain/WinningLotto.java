package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final Ball bonus;

    public WinningLotto(final Lotto lotto, final Ball bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(final Lotto lotto, final Ball bonus) {
        if (lotto.isContains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
