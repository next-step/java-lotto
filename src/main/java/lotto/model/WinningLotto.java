package lotto.model;

import lotto.exception.DuplicateLottoNumberException;

import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonus;

    private WinningLotto(Lotto lotto, Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(String inputOfNumbers, int inputOfBonusNumber) {
        return of(Lotto.ofComma(inputOfNumbers), Number.of(inputOfBonusNumber));
    }

    public static WinningLotto of(Lotto lotto, Number bonus) {
        if (lotto.hasBonusNumber(bonus)) {
            throw new DuplicateLottoNumberException(bonus);
        }
        return new WinningLotto(lotto, bonus);
    }

    Number getBonus() {
        return bonus;
    }

    Prize match(Lotto lotto) {
        return Prize.of(this.lotto.getMatchCount(lotto), lotto.hasBonusNumber(bonus));
    }

    Lotto getLotto() {
        return lotto;
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
