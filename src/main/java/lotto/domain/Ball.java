package lotto.domain;

public class Ball {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE =
            "로또 숫자는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + "의 범위를 가질 수 있습니다.";
    private final int value;

    public Ball(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        int number = Integer.parseInt(value);

        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
