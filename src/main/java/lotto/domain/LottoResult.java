package lotto.domain;

import java.util.List;

public class LottoResult {
    private Lottos lottos;

    public LottoResult(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<Integer> checkWinningNumbers(String winningNumbers) {
        Lotto winningLotto = new Lotto(winningNumbers);

        return lottos.matchesLottos(winningLotto);
    }

}
