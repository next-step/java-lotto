package lotto.model;

import java.util.*;

public class WinningLogic {

    public WinningState makeWinningState(Lotto lotto, WinningLotto winningLotto) {
        int winningCount = makeWinningCount(lotto.getLottoNumbers(), winningLotto.getLottoNumbers());
        LottoNumber bonusBallNumber = winningLotto.getBonusBall();
        WinningState winningState = new WinningState(winningCount, checkBonusCount(lotto, bonusBallNumber));

        return winningState;
    }

    private int makeWinningCount(Set<LottoNumber> lottoNumbers, Set<LottoNumber> winningLotto) {
        int winningCount = 0;

        for (LottoNumber winningNumber : winningLotto) {
            winningCount += compareWithWinningLotto(lottoNumbers, winningNumber);
        }

        return winningCount;
    }

    private int compareWithWinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber winningLotto) {
        if (lottoNumbers.contains(winningLotto)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusCount(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.contain(bonusNumber);
    }
}
