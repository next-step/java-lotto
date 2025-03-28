package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {
    public void printLottoTickets(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        for (LottoTicket ticket : tickets.getAll()) {
            System.out.println(ticket);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoPrize prize : LottoPrize.values()) {
            if (prize == LottoPrize.NONE) continue;

            int matchCount = prize.getMatchCount();
            int prizeMoney = prize.getPrize();
            int count = lottoResult.getWinningCountsByPrize()
                    .getOrDefault(prize, 0);

            System.out.printf("%d개 일치 (%d원)- %d개%n", matchCount, prizeMoney, count);
        }

        double profitRate = lottoResult.getProfitRate();
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
    }
}
