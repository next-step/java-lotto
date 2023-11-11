package lotto.domain;

public class Bonus {
    private final LottoNumber bonusNumber;

    public Bonus(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean compareWith(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }
}
