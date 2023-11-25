package lotto.model;

public class BonusBall {
    private final LottoNumber bonusNumber;

    public BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber bonus() {
        return this.bonusNumber;
    }

    public int number() {
        return this.bonusNumber.number();
    }

    public boolean isBonusBall(LottoNumber number) {
        return number.equals(this.bonusNumber);
    }
}
