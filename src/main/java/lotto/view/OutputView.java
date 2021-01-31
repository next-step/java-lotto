package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinnerStatistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class OutputView {

    public void printLottoTickets(final LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(lottoTicket);
        }
    }

    public void printStatistics(final WinnerStatistics winnerStatistics, final LottoTickets lottoTickets) {
        EnumMap<Rank, Integer> results = winnerStatistics.getResults();
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);

        System.out.println("당첨 통계");
        System.out.println("---------");
        for (final Rank rank : ranks) {
            if (isNone(rank)) continue;
            int matchCount = results.getOrDefault(rank, 0);
            System.out.println(rank.toString() + matchCount + "개");
        }
        System.out.println("총 수익률은 " + winnerStatistics.getEarningRate(lottoTickets.getPurchaseAmount()) + "입니다.");
    }

    private boolean isNone(final Rank rank) {
        return rank == Rank.NONE;
    }

    public void printPurchaseCount(final LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getPurchaseCount() + "개를 구매했습니다.");
    }
}
