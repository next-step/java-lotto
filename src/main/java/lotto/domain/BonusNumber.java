package lotto.domain;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean matchesBonusNumber(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}

