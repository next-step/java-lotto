package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinnerStatistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    public void printLottoTickets(final List<LottoTicket> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public void printStatistics(final WinnerStatistics winnerStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        for (final Rank rank : ranks) {
            if (isNone(rank)) continue;
            int rankCount = winnerStatistics.getRankCount(rank);
            System.out.println(rank.toString() + rankCount + "개");
        }
        System.out.println("총 수익률은 " + winnerStatistics.calculateEarningRate() + "입니다.");
    }

    private boolean isNone(final Rank rank) {
        return rank == Rank.NONE;
    }
}
