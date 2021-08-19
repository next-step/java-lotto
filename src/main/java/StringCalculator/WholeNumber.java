package StringCalculator;

import java.util.Objects;

public class WholeNumber {

    private static final int MINIMUM_NUMBER = 0;
    private final int number;

    public WholeNumber(int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if(number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("음수는 덧셈 대상이 될 수 없습니다.");
        }
    }

    public int getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WholeNumber that = (WholeNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
