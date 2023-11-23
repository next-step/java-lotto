package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int num;

    public LottoNumber(int num) {
        this.num = num;
        validNum();
    }

    public int getNum() {
        return num;
    }

    private void validNum() {
        if (isUnderLowerBound() || isOverUpperBound()) {
            throw new IllegalArgumentException("로또 번호 생성중 오류가 발생했습니다.");
        }
    }

    private boolean isUnderLowerBound() {
        return num < LottoConfig.LOWER_BOUND;
    }

    private boolean isOverUpperBound() {
        return num > LottoConfig.UPPER_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
