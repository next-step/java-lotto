package lotto.model.domain;

import lotto.model.game.LottoNumber;

import java.util.Objects;

public class Lotto implements Comparable<Lotto> {

    private final int number;

    public Lotto(int number) {
        checkValidation(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void checkValidation(int number) {
        if (number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자 범위에 속하지 않습니다.");
        }
    }

    @Override
    public int compareTo(Lotto other) {
        return Integer.compare(number, other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return number == lotto.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}