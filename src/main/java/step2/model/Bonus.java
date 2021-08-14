package step2.model;

public class Bonus {
    private LottoNumber bonusNumber;

    public Bonus(String bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber.getLottoNumber();
    }
}
