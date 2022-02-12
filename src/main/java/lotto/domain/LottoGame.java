package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public Map<Ranking, Integer> findWinner() {

        final Map<Ranking, Integer> totalResult = new HashMap<>();
        initializeTotalResult(totalResult);

        final List<Ranking> rankings = lottos.judgeAllUserLotto(winningLotto);
        rankings.forEach(ranking -> updateResults(totalResult, ranking));

        return totalResult;
    }

    private void initializeTotalResult(final Map<Ranking, Integer> totalResult) {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> totalResult.put(ranking, ZERO));
    }

    private void updateResults(final Map<Ranking, Integer> totalResult, final Ranking ranking) {
        Integer currentCount = totalResult.get(ranking);
        totalResult.put(ranking, ++currentCount);
    }

    public BigDecimal calculateYield(final Map<Ranking, Integer> totalResult, final Money money) {
        final List<Ranking> rankings = new ArrayList<>(totalResult.keySet());

        final BigDecimal totalWinnerPrize = BigDecimal.valueOf(rankings.stream()
            .mapToInt(ranking ->
                ranking.multiplyCountAndWinnerPrice(totalResult.get(ranking)))
            .sum());

        return totalWinnerPrize.divide(BigDecimal.valueOf(money.getMoney()));
    }

    public Lottos getLottos() {
        return lottos;
    }
}
