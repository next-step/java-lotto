package lotto.domain;

import java.util.List;

public class LottoStatistics {
    private final List<Lotto> ticket;

    public LottoStatistics(List<Lotto> ticket) {
        this.ticket = ticket;
    }

    public static LottoWinningResults getLottoWinningResult(
            final List<Lotto> ticket,
            final Lotto lastWeekWinningNumbers
    ) {
        LottoWinningResults lottoWinningResults = new LottoWinningResults();
        ticket.forEach(lotto -> {
            int winningCount = lotto.getMatchingNumberCount(lastWeekWinningNumbers);
            lottoWinningResults.incrementWinningResults(winningCount);
        });
        return lottoWinningResults;
    }
}
