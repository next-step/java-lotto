package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validateWinningLotto(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto winningLotto() {
        return winningLotto;
    }

    public List<LottoNumber> lottoNumbers() {
        return winningLotto.lottoNumbers();
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    private void validateWinningLotto(Lotto winningLotto) {
        if (winningLotto == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }

        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 보너스 번호와 중복되는 번호가 들어가 있습니다.");
        }
    }
}
