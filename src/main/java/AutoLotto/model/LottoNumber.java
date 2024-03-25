package autoLotto.model;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBER = "로또 번호는 1 ~ 45 이하의 숫자 1개의 값만 사용이 가능합니다.";

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateNumber(int lotto) {
        if (!isValidLottoNumber(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    public boolean isSameNumber(int number) {
        return lottoNumber == number;
    }
}
