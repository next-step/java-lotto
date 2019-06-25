package lotto.model;

import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final Number bonus;

    public WinningLotto(Lotto lotto, Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(Lotto lotto, Number bonus) {
        return new WinningLotto(lotto, bonus);


    }

    Lotto getLotto() {
        return lotto;
    }

    Number getNumber() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonus);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                ", bonus=" + bonus +
                '}';
    }
}
