package step3.domain;

public class LottoNumber {

    private final int number;

    private LottoNumber(int number) {
        inputValidation(number);
        this.number = number;
    }

    private void inputValidation(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public int number() {
        return number;
    }
}
