package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoMatcher {

    public static WinningResults calculateWinningResults(final LottoList lottos, final WinningLotto winningLotto) {
        WinningResults winningResults = new WinningResults();

        List<Prize> prizes = Arrays.asList(Prize.values());

        for (Prize prize : prizes) {
            winningResults.put(
                    prize, new WinningResult(prize, lottos.count(prize, winningLotto)));
        }

        return winningResults;
    }
}
