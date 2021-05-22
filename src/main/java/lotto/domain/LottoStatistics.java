package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> winningResults;

    public LottoStatistics() {
        this.winningResults = new HashMap<>();
    }

    public void init(final LottoGame lottoGame, final Lotto winnerLotto) {
        makeWinningResults(lottoGame.getLottoes(), winnerLotto);
    }

    private void makeWinningResults(final Lottoes lottoes, final Lotto winnerLotto) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningResults.put(rank, lottoes.getRankCount(winnerLotto, rank)));
    }

    public Map<Rank, Integer> getWinningResults() {
        return Collections.unmodifiableMap(winningResults);
    }
}
