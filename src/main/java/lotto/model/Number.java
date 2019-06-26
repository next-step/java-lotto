package lotto.model;

public class Number {

    static final int MIN = 1;
    static final int MAX = 45;

    private int number;

    public Number(int number) {
        verifyNumber(number);
        this.number = number;
    }

    void verifyNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1~45 범위에서만 생성 가능 합니다.");
        }
    }
}
