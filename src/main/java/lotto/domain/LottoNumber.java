package lotto.domain;

public class LottoNumber {
    private static final String RANGE_EXCEPTION_MESSAGE = "로또 번호는 1과 45사이의 숫자여야 합니다.";

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumberRange(int lottoNumber) {
        if (!isLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isLottoNumber(int lottoNumber) {
        return lottoNumber > Lotto.MININUM_NUMBER && lottoNumber < Lotto.MAXIMUM_NUMBER;
    }
}
