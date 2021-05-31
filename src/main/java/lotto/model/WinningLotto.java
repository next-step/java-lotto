package lotto.model;

import java.util.Set;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusBall = bonusBall;
    }

    public WinningState makeWinningState(Lotto lotto) {
        int winningCount = makeWinningCount(lotto.getLottoNumbers(), getLottoNumbers());
        WinningState winningState = new WinningState(winningCount, checkBonusCount(lotto, this.bonusBall));

        return winningState;
    }

    private int makeWinningCount(Set<LottoNumber> lottoNumbers, Set<LottoNumber> winningLottoNumbers) {
        return winningLottoNumbers.stream()
                .mapToInt((winningLottoNumber) -> compareWithWinningLotto(lottoNumbers, winningLottoNumber))
                .sum();
    }

    private int compareWithWinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber winningLottoNumber) {
        if (lottoNumbers.contains(winningLottoNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusCount(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.contain(bonusNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return winningLotto.getLottoNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
