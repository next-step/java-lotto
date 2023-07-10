package lotto.domain;

public class Ball {

    private final int value;

    public Ball(final String value) {
        validate(value);

        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        int number = Integer.parseInt(value);

        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException();
        }
    }
}
