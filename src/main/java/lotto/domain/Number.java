package lotto.domain;

import java.util.Objects;

public class Number {
    private final Integer number;
    private final Position position;

    public Number(Integer number, Position position) {
        if(number < LottoMachine.FIRST_NUMBER || number > LottoMachine.LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.number = number;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number thatNumber = (Number) o;
        return number == thatNumber.number && position.equals(thatNumber.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                ", position=" + position +
                '}';
    }
}
