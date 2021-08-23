package step4.lotto;

public class BonusNumber {

    private final LottoNo number;

    public BonusNumber(int number) {
        this.number = new LottoNo(number);
    }

    public LottoNo getNumber() {
        return number;
    }
}
