package lotto.model;

public class Number {

    private int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        isLottoNumber(number);
        return new Number(number);
    }

    private static void isLottoNumber(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("로또 숫자는 1부터 45의 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
