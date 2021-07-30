package lotto.domain;

public class LottoNumber {

    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "1부터 45 사이의 숫자를 등록해야 합니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        checkNumbersRange(number);
        this.number = number;
    }

    private void checkNumbersRange(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return this.number;
    }

}
