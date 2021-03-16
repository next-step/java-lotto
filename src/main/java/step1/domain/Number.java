package step1.domain;

public class Number {

    public static final int MIN_WIDTH = 0;

    private final int number;

    public Number(String number) {
        int i = Integer.parseInt(number);
        this.number = isMinusValid(i);
    }

    private int isMinusValid(int number) {
        if (number < MIN_WIDTH) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}
