package step2.domain.model;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber createLottoNumber(int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
