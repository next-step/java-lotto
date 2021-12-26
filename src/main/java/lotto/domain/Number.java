package lotto.domain;

import java.util.Objects;

public class Number {
    private final Integer number;

    public Number(Integer number) {
        if (number < LottoMachine.FIRST_NUMBER || number > LottoMachine.LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number thatNumber = (Number) o;
        return number == thatNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
