package lotto.oop.domain;

import java.util.Objects;

public class LottoNo {
    public final static int MIN_LIMIT = 0;
    public final static int MAX_LIMIT = 45;
    private int num;

    public LottoNo(int num) {
        if (num < MIN_LIMIT || num > MAX_LIMIT) {
            throw new ArithmeticException("유효 범위를 벗어났습니다.");
        }
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return num == lottoNo.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
