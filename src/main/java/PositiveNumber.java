import java.util.Objects;

public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        validateNegative(number);
        this.number = number;
    }

    public int addInt(int number){
        return this.number + number;
    }

    private int validateNegative(int number) {
        if (hasNegative(number)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private boolean hasNegative(int number) {
        return number < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}