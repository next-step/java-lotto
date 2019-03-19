package lotto.vo;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {
    private static final int LOTTO_NO_MIN = 1;
    private static final int LOTTO_NO_MAX = 45;
    private int number;

    public LottoNo(int number) throws IllegalArgumentException {
        if (number < LOTTO_NO_MIN || number > LOTTO_NO_MAX) {
            throw new IllegalArgumentException("번호 범위 안맞음");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNo o) {
        if (number > o.number) {
            return 1;
        } else if (number < o.number) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
