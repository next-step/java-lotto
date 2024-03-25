package lotto.domain;

import java.util.Objects;

import static lotto.controller.LottoGame.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(String.format("%d부터 %d 사이의 정확한 숫자를 입력해주세요", START_INCLUSIVE, END_INCLUSIVE));
        }
        this.number = number;
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

    @Override
    public int compareTo(LottoNumber o) {
        if (number < o.number) {
            return -1;
        } else if(number > o.number) {
            return 1;
        }
        return 0;
    }

    public int getNumber() {
        return number;
    }
}
