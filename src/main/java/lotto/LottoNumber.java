package lotto;

public class LottoNumber {
    private final int number;

    public LottoNumber(final int number) {
        checkNumber(number);
        this.number = number;
    }

    private void checkNumber(int number) {
        if(number > 45 || number < 1) {
            throw new IllegalArgumentException("유효한 숫자 범위는 1~45 입니다.");
        }
    }
}
