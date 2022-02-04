package lotto.domain;

public class LottoNumber {

    private final int lottoNum;

    public LottoNumber(int lottoNum) {
        validateNumberRange(lottoNum);

        this.lottoNum = lottoNum;
    }

    private void validateNumberRange(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("복권의 숫자 범위가 유효하지 않습니다.");
        }
    }

    public int getLottoNum() {
        return lottoNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNum == that.lottoNum;
    }

    @Override
    public int hashCode() {
        return lottoNum;
    }
}
