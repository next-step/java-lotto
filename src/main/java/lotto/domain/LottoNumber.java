package lotto.domain;

public class LottoNumber {

    public static final String LOTTO_NUMBER_BOUNDARY_ERROR_MESSAGE = "로또 번호는 1 ~ 45 사이의 수여야 합니다.";
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(Integer lottoNumber) {
        if (!ValidationUtils.isValidLottoNumberBoundary(lottoNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_BOUNDARY_ERROR_MESSAGE);
        }
    }
}
