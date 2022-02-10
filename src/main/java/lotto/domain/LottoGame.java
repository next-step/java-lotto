package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int ZERO = 0;

    private final Map<Ranking, Integer> totalResult = new HashMap<>();

    public LottoGame() {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> totalResult.put(ranking, ZERO));
    }

    public Lottos startLotto(final Money money, final LottoShop lottoShop) {
        final int lottoAmount = lottoShop.countPossibleLottoAmount(money);
        return lottoShop.buyLotto(lottoAmount);
    }

    public Map<Ranking, Integer> findWinner(final WinningLotto winningLotto,
        final Lottos userLottos) {

        final List<Ranking> rankings = userLottos.judgeAllUserLotto(winningLotto);

        updateResults(rankings);

        return totalResult;
    }

    private void updateResults(final List<Ranking> rankings) {
        rankings.forEach(ranking -> {
            Integer currentCount = totalResult.get(ranking);
            totalResult.put(ranking, ++currentCount);
        });
    }

}
