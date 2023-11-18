package lotto.domain;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {
    private final int num;

    public LottoNum(int num) {
        validate(num);
        this.num = num;
    }

    private void validate(int num) {
        if (num <= 0 || num >= 46) {
            throw new IllegalArgumentException("로또 숫자는 1~45까지만 가능합니다.");
        }
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(LottoNum o) {
        return this.num - o.num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
