package model.lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkValidBonusBall(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String value, int bonusNumber) {
        this(new Lotto(value), new LottoNumber(bonusNumber));
    }

    private void checkValidBonusBall(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            throw new IllegalArgumentException("보너스볼은 중복되면 안됩니다.");
        }
    }

    public boolean containsWinNumber(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public boolean containsWinBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
