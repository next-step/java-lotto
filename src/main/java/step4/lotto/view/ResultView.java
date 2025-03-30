package step4.lotto.view;

import step4.lotto.model.Count;
import step4.lotto.model.LottoMatchCount;
import step4.lotto.model.LottoPrize;
import step4.lotto.model.LottoResult;
import step4.lotto.model.LottoTicket;
import step4.lotto.model.LottoTicketList;
import step4.lotto.model.Money;

public class ResultView {

    public void printLottoTicketCount(LottoTicketList lottoTickets) {
        System.out.println(lottoTickets.value().size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets.value()) {
            printLottoTicket(lottoTicket);
        }
        System.out.println();
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket);
    }

    public void printLottoResultTitle() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printLottoResult(LottoResult lottoResult, Money purchaseAmount) {
        printLottoPrizeResult(LottoPrize.FIFTH, lottoResult.ticketCountOf(LottoPrize.FIFTH));
        printLottoPrizeResult(LottoPrize.FOURTH, lottoResult.ticketCountOf(LottoPrize.FOURTH));
        printLottoPrizeResult(LottoPrize.THIRD, lottoResult.ticketCountOf(LottoPrize.THIRD));
        printLottoPrizeResult(LottoPrize.SECOND, lottoResult.ticketCountOf(LottoPrize.SECOND));
        printLottoPrizeResult(LottoPrize.FIRST, lottoResult.ticketCountOf(LottoPrize.FIRST));

        printRateOfReturn(lottoResult, purchaseAmount);
    }

    public void printLottoPrizeResult(LottoPrize lottoPrize, Count lottoTicketCount) {
        LottoMatchCount lottoMatchCount = LottoPrize.matchCountOf(lottoPrize);
        Money lottoPrizeMoney = LottoPrize.moneyOf(lottoPrize);
        if (lottoPrize.equals(LottoPrize.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", lottoMatchCount.value(), lottoPrizeMoney.value(), lottoTicketCount.value());
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개\n", lottoMatchCount.value(), lottoPrizeMoney.value(), lottoTicketCount.value());
    }

    public void printRateOfReturn(LottoResult lottoResult, Money purchaseAmount) {
        double rateOfReturn = lottoResult.rateOfReturn(purchaseAmount);
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 ", rateOfReturn);
        if (rateOfReturn == 1) {
            System.out.println("결과적으로 본전이라는 의미임)");
        }
        if (rateOfReturn > 1) {
            System.out.println("이익이라는 의미임)");
        }
        if (rateOfReturn < 1) {
            System.out.println("손해라는 의미임)");
        }
    }

}
