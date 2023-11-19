package lotto.domain;

public class LottoNumber {
    private static final int ONE = 1;
    private static final int FORTY_FIVE = 1;
    private int number;
    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private static void validateNumber(int number) {
        if (number < ONE || number > FORTY_FIVE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자입니다.");
        }
    }
}
