package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private int number;

    public LottoNumber(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public int compareTo(LottoNumber o) {

        if(this.number < o.getNumber()) {
            return -1;
        }

        if(this.number > o.getNumber()) {
            return 1;
        }

        return 0;
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
        return Objects.hash(number);
    }

}
