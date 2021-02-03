package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseResult;
import lotto.domain.Rank;
import lotto.domain.WinnerStatistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printLottoTickets(final List<LottoTicket> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printStatistics(final WinnerStatistics winnerStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        for (final Rank rank : ranks) {
            if (isNone(rank)) continue;
            int rankCount = winnerStatistics.getWinningCountByRank(rank);
            System.out.println(rank.toString() + rankCount + "개");
        }
        System.out.println("총 수익률은 " + winnerStatistics.calculateEarningRate() + "입니다.");
    }

    @Override
    public void printLottoTickets(final PurchaseResult manual, final PurchaseResult auto) {
        int manualPurchaseCount = manual.getCount();
        int autoPurchaseCount = auto.getCount();
        System.out.println();
        System.out.println("수동으로 " + manualPurchaseCount + "장, 자동으로 " + autoPurchaseCount + "개를 구매했습니다.");
        auto.getLottoTickets().forEach(System.out::println);
        System.out.println();
    }

    private boolean isNone(final Rank rank) {
        return rank == Rank.NONE;
    }
}
