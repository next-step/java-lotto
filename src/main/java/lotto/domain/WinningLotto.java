package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto winningLotto;

    public WinningLotto(String winningNumbers) {
        this.winningLotto = LottoFactory.createManualLotto(winningNumbers);
    }

    public List<Integer> checkWinningNumbers(Lottos lottos) {
        return lottos.matchesLottos(winningLotto);
    }
}
