package lotto.domain;

public class Bonus {

    private final LottoNumber bonusNumber;

    public Bonus(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
