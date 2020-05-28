package step2.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private Integer number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber newInstance(Integer number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number.toString();
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number.compareTo(o.number);
    }
}
