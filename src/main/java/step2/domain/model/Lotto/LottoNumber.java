package step2.domain.model.Lotto;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
