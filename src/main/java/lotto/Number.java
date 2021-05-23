package lotto;

import java.util.Objects;

public final class Number {

    private int number;

    public Number(int number) {
        if( 1 > number || number > 45){
            throw new IllegalArgumentException("로또 숫자 범위는 1 ~ 45 사이입니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
