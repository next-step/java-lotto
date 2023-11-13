package calculator.domain;

public class Digit {
    private final int num;

    public Digit(String digit) {
        int num = Integer.parseInt(digit);
        validate(num);
        this.num = num;
    }

    public static Digit of(String digit) {
        return new Digit(digit);
    }

    public int getNum() {
        return num;
    }

    public void validate(int num) {
        if (num < 0 || num >= 10) {
            throw new IllegalArgumentException("0~9 사이의 숫자만 입력이 가능합니다.");
        }
    }
}
