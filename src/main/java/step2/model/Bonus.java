package step2.model;

public class Bonus {
    private final LottoNumber bonusNumber;

    public Bonus(Lotto winningNumbers, String bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
        winningNumbers.isDuplicate(this.bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
