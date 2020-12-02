package lotto.domain;

public class LottoNumber implements Comparable {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    private static final int PRIME = 31;

    private final int lottoNum;

    public LottoNumber(int lottoNum) {
        validNumber(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validNumber(int lottoNum) {
        if (lottoNum < MIN_LOTTO_NUM || lottoNum > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("로또번호는 1부터 45까지 입력이 가능합니다.");
        }
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof LottoNumber)) {
            return 0;
        }
        return this.lottoNum - ((LottoNumber) o).lottoNum;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNum == that.lottoNum;
    }

    @Override
    public int hashCode() {
        return PRIME + lottoNum;
    }
}
