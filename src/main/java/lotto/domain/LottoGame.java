package lotto.domain;

import java.util.Arrays;
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
        initializeTotalResult(totalResult);

        final List<Ranking> rankings = lottos.judgeAllUserLotto(winningLotto);
        rankings.forEach(ranking -> updateResults(ranking, totalResult));

        return new LottoResults(totalResult);
    }

    private void initializeTotalResult(final Map<Ranking, Integer> totalResult) {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> totalResult.put(ranking, ZERO));
    }

    private void updateResults(final Ranking ranking, final Map<Ranking, Integer> totalResult) {
        Integer currentCount = totalResult.get(ranking);
        totalResult.put(ranking, ++currentCount);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
