package step2;

public class LottoNumber {
    public static final String LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1 이상 45 이하의 숫자여야 합니다.";

    private int lottoNumber;

    public LottoNumber(int number) {
        assertNumber(number);
        this.lottoNumber = number;
    }

    private void assertNumber(int number) {
        if(!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
