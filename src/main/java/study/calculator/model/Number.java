package study.calculator.model;

public class Number {
    private static final int NUMBER_ZERO = 0;

    private final int value;

    public Number(String str) {
        this.value = convertIntToString(str);
    }

    public int getValue() {
        return value;
    }

    private int convertIntToString(String str) {
        if(str.isEmpty()) {
            throw new IllegalArgumentException("빈 문자가 존재합니다.");
        }

        int number = Integer.parseInt(str);

        if(number < NUMBER_ZERO) {
            throw new IllegalArgumentException("음수는 입력 불가능 합니다.");
        }

        return number;
    }
}
