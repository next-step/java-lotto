package lotto.domain;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int isgreaterThan(LottoNumber operand) {
        return this.number - operand.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
