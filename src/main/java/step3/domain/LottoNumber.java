package step3.domain;

public class LottoNumber {

    private final int number;
    private boolean isBonus = false;

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(int number, boolean isBonus) {
        return new LottoNumber(number, isBonus);
    }

    private LottoNumber(int number) {
        inputValidation(number);
        this.number = number;
    }

    private LottoNumber(int number, boolean isBonus) {
        this(number);
        this.isBonus = isBonus;
    }

    private void inputValidation(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int number() {
        return number;
    }
}
