package lotto.domain;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("번호는 [" + MIN_NUMBER + "," + MAX_NUMBER + "]의 범위 안에 있어야합니다.");
        }
    }

    private boolean isInvalidNumber(int number) {
        return MIN_NUMBER > number || MAX_NUMBER < number;
    }

    int getNumber() {
        return number;
    }
}
