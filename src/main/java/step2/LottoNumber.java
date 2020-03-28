package step2;

public class LottoNumber {
    public static final String LOTTO_NUMBER_RANGE_ERROR = "로또 번호는 1과 45 사이의 정수여야 합니다.";
    private static int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if(lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }
}
