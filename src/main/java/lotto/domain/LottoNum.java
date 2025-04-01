package lotto.domain;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {

    public final static int MIN_NUM = 1;
    public final static int MAX_NUM = 45;
    private final int num;

    public LottoNum(int num) {
        validateNumber(num);
        this.num = num;
    }

    private void validateNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUM || lottoNumber > MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
    }

    public int num() {
        return num;
    }

    @Override
    public int compareTo(LottoNum other) {
        return Integer.compare(this.num, other.num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNum)) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

}
