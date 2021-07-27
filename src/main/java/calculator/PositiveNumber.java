package calculator;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(String number) {
        this.number = validate(number);
    }

    public static PositiveNumber of(String number) {
        return new PositiveNumber(number);
    }

    public int initNumber() {
        return number;
    }

    private int validate(String number) {
        int parseInt = Integer.parseInt(number);
        if (!isPositiveNumber(parseInt)) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return parseInt;
    }

    private boolean isPositiveNumber(int num) {
        return num > 0;
    }
}
