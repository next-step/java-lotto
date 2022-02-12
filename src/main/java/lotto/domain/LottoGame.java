package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int ZERO = 0;

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(final Lottos lottos, final WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public LottoResults findWinner() {
        final Map<Ranking, Integer> totalResult = new HashMap<>();
        final LottoResults lottoResults = new LottoResults(totalResult);

        final List<Ranking> rankings = lottos.judgeAllUserLotto(winningLotto);
        rankings.forEach(ranking -> lottoResults.updateResults(ranking));

        return lottoResults;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
