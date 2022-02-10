package lotto.domain;

public class LottoNumber {

    private static final int LOTTO_VALID_NUM_START = 1;
    private static final int LOTTO_VALID_NUM_END = 45;
    private static final String INVALID_NUMBER_RANGE = "복권의 숫자 범위가 유효하지 않습니다.";

    private final int lottoNum;

    public LottoNumber(int lottoNum) {
        validateNumberRange(lottoNum);

        this.lottoNum = lottoNum;
    }

    private void validateNumberRange(final int number) {
        if (number < LOTTO_VALID_NUM_START || number > LOTTO_VALID_NUM_END) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
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

    @Override
    public String toString() {
        return lottoNum + "";
    }
}
