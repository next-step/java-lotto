package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String winningLotto, String bonusNumber) {
        this(new Lotto(winningLotto), LottoNumber.valueOf(bonusNumber));
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    public boolean hasBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(winningLotto);
    }
}
