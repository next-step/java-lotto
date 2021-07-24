package calculator;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String number) {
        this.number = Integer.parseInt(number);
        if (!isPositiveNumber(this.number)) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    private boolean isPositiveNumber(int num) {
        return num > 0;
    }
}
