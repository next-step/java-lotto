package lotto.domain;

public class BonusNumber {

    private final int bonus;

    public BonusNumber(int value) {
        if (value < 0 || value > 45) {
            throw new IllegalArgumentException();
        }
        this.bonus = value;
    }

    public LottoNumber toLottoNumber() {
        return new LottoNumber(bonus);
    }
}
