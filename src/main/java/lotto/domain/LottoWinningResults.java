package lotto.domain;

import java.util.List;

public class LottoWinningResults {
    private final List<LottoWinningResult> lottoWinningResults;

    public LottoWinningResults(final List<LottoWinningResult> results) {
        this.lottoWinningResults = results;
    }

    public int winningCount(final LottoRank rank) {
        final long count = lottoWinningResults
            .stream()
            .filter(result -> result.isRankMatch(rank))
            .mapToInt(LottoWinningResult::size)
            .sum();
        return (int) count;
    }

    public long totalWinningPrice() {
        return lottoWinningResults
            .stream()
            .map(LottoWinningResult::totalWinningPrice)
            .reduce(0L, Long::sum);
    }
}
