package StringCalculator;

public class Number {

    private final int number;
    private static final int MINIMUM_NUMBER = 0;

    public Number(int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if(number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("음수는 덧셈 대상이 될 수 없습니다.");
        }
    }
}
