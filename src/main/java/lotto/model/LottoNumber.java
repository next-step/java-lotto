package lotto.model;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        checkNumber(number);
        this.number = number;
    }

    private void checkNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("당첨번호는 1부터 45까지의 숫자입니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
