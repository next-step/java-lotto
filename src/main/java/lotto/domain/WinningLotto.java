package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = LottoNumber.of(validateBonusNumber(bonusNumber));
    }

    public int validateBonusNumber(int bonusNumber) {
        winningLotto.validateDuplicate(bonusNumber);
        return bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getLottoNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getLottoNumber();
    }

    public LottoRank getLottoResult(Lotto lotto) {
        int equalCount = getMatchCount(lotto);
        return LottoRank.matchRank(equalCount, lotto.isNumberContain(bonusNumber.getLottoNumber()));
    }

    private int getMatchCount(Lotto lotto) {
        return (int) getWinningLotto().stream()
                .filter(num -> lotto.isNumberContain(num))
                .count();
    }
}
