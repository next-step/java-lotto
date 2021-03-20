package lotto.domain;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final String LOTTO_NUMBER_SIZE_ERROR = "당첨 번호는 1 부터 45 이내 입력해주세요.";

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        isLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void isLottoNumberRange(int result) {
        if (isLottoNumberSize(result)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    private boolean isLottoNumberSize(int number) {
        return (MIN_NUMBER > number)
                || (MAX_NUMBER < number);
    }

    public int lottoNumber() {
        return lottoNumber;
    }

    public boolean checkNumber(LottoNumber number) {
        return lottoNumber == number.lottoNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
