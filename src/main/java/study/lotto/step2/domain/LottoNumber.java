package study.lotto.step2.domain;

public class LottoNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if(isOutOfRange(number)) {
            throw new IllegalArgumentException("로또 번호는 " + MINIMUM_NUMBER + " 이상 " +
                    MAXIMUM_NUMBER + " 이하의 정수입니다: " + number);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MINIMUM_NUMBER || MAXIMUM_NUMBER < number;
    }
}
