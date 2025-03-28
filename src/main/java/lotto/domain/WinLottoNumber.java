package lotto.domain;

public class WinLottoNumber {

    private final Lotto winLotto;
    private final LottoNum bonusNumber;

    public WinLottoNumber(Lotto winLotto, LottoNum bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
        checkDuplicateWithBonus();
    }

    public Lotto winLotto() {
        return winLotto;
    }

    public LottoNum bonusNumber() {
        return bonusNumber;
    }

    private void checkDuplicateWithBonus() {
        if (winLotto.lottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
