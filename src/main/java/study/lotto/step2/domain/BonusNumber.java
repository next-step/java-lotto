package study.lotto.step2.domain;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(String bonusNumber) {
        this(LottoNumber.of(bonusNumber));
    }

    public BonusNumber(int bonusNumber) {
        this(LottoNumber.of(bonusNumber));
    }

    public BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getLottoNumbers().getLottoNumbers().contains(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return bonusNumber.toString();
    }
}
