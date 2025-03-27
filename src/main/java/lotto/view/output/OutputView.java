package lotto.view.output;

import lotto.domain.PaymentReceipt;
import lotto.domain.product.FinalResult;
import lotto.domain.product.LotteryTickets;
import lotto.domain.product.LottoRank;

public class OutputView {

    public void printResult(FinalResult result, PaymentReceipt paid) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NO_WIN) {
                continue;
            }

            int count = result.get(rank.getMatchCount()) != null ? result.get(rank.getMatchCount()) : 0;

            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    rank.getMatchCount(),
                    rank.getPrize(),
                    count);
        }

        System.out.printf("총 수익률은 %.2f입니다.\n", result.returnRate(paid));
    }

    public void userPurchased(Integer count) {
        System.out.println(count + "개를 구매 했습니다.");
    }

    public void printAutoLottery(LotteryTickets tickets) {
        System.out.println(tickets.getLotteryTickets());
    }
}
