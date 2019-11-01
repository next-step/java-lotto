package domain;

import java.util.Objects;

public class SafeNumber {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final int MINIMUM_VALUE = 0;
    private Integer number;

    public SafeNumber(final String maybeNumber) {
        int number = convert(maybeNumber);
        checkMinimum(number);

        this.number = number;
    }

    private int convert(String maybeNumber) {
        try {
            return Integer.parseInt(maybeNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException(maybeNumber + " 는 숫자가 아닙니다.");
        }
    }

    private void checkMinimum(int number) {
        if (number < MINIMUM_VALUE) {
            throw new RuntimeException(number + " : 음수는 허용되지 않습니다.");
        }
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeNumber that = (SafeNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
