package calculator;

import java.util.Objects;

/**
 * 편의상 0 도 포함
 */
class NatualNum {

    private final int number;
    static final NatualNum ZERO = new NatualNum(0);

    NatualNum(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않는다.");
        }
        this.number = number;
    }

    NatualNum plus(NatualNum other) {
        return new NatualNum(number + other.getNumber());
    }

    int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatualNum natualNum = (NatualNum) o;
        return number == natualNum.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
