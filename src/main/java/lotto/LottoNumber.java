package lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1~45까지 입니다.";

    private int number;

    public LottoNumber(int number) {
        validateLottoNumber();
        this.number = number;
    }

    private void validateLottoNumber() {
        if (number < MIN_NUMBER && number > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.number < lottoNumber.number) {
            return -1;
        } else if (this.number == lottoNumber.number) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
