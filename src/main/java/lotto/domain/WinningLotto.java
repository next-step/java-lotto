package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    public int validateBonusNumber(int bonusNumber) {
        winningLotto.validateDuplicate(bonusNumber);
        return bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getLottoNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
