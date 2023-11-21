package lotto.model;

public class BonusBall {
    private final LottoNumberValidate bonusNumber;

    public BonusBall(LottoNumberValidate bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoNumberValidate bonus() {
        return this.bonusNumber;
    }

    public int number() {
        return this.bonusNumber.number();
    }

    public boolean isBonusBall(LottoNumberValidate number) {
        return number.equals(this.bonusNumber);
    }
}
