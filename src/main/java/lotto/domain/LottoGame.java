package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int ZERO = 0;

    private final Lottos lottos;

    public LottoGame(final Lottos lottos) {
        this.lottos = lottos;
    }


    public Map<Ranking, Integer> findWinner(final WinningLotto winningLotto,
        final Lottos userLottos) {

        final Map<Ranking, Integer> totalResult = new HashMap<>();
        initializeTotalResult(totalResult);

        final List<Ranking> rankings = userLottos.judgeAllUserLotto(winningLotto);
        rankings.forEach(ranking -> {
            Integer currentCount = totalResult.get(ranking);
            totalResult.put(ranking, ++currentCount);
        });

        return totalResult;
    }

    private void initializeTotalResult(final Map<Ranking, Integer> totalResult) {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> totalResult.put(ranking, ZERO));
    }

    public Lottos getLottos() {
        return lottos;
    }
}
