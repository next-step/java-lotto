package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private final String ERROR_LOTTO_NUM_MSG = "[오류] Lotto 번호가 45이상 입니다.";
    int num;

    public Number(int num) {
        this.num = num;
        isLottoNumber();
    }

    private void isLottoNumber() {
        if (num > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUM_MSG);
        }
    }

    public int getNum() {
        return num;
    }

    public String getNumToString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(Number num) {
        return Integer.compare(getNum(), num.getNum());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Number num = (Number) obj;
        return this.getNum() == num.getNum();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}
