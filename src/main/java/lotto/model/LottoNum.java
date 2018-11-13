package lotto.model;

import java.util.Objects;

public class LottoNum {
    public static final int RANDOM_NUM_MAX = 45;
    public static final int RANDOM_NUM_MIN = 1;
    private int num;

    public LottoNum(int num) {
        if (num < RANDOM_NUM_MIN || num > RANDOM_NUM_MAX) {
            throw new IllegalArgumentException("숫자는" + RANDOM_NUM_MIN + "과 " + RANDOM_NUM_MAX + "사이여햐합니다.");
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
