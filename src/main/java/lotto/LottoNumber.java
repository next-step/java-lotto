package lotto;

public class LottoNumber {
    private int number;
    public LottoNumber(int number) {
        validation(number);
        this.number = number;
    }
    private void validation(int number) {
        if (number < 1 || number > 45) {
            throw new RuntimeException("로또 번호는 1부터 45입니다.");
        }
    }

    public int value() {
        return this.number;
    }
}
