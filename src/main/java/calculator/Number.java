package calculator;

public class Number {

    private final int number;

    private Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
       }
    }

    public static Number of(String strNumber) {
        try {
            int number = Integer.parseInt(strNumber);
            return new Number(number);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자로 변환이 불가능한 문자열입니다.");
        }
    }

    public int sum(int number) {
        return this.number + number;
    }
}
