package step3.lotto.view;

import java.util.List;
import step3.lotto.model.Count;
import step3.lotto.model.LottoMatchCount;
import step3.lotto.model.LottoPrize;
import step3.lotto.model.LottoResult;
import step3.lotto.model.LottoTicket;

public class ResultView {

    public void printLottoTicketCount(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
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

    public void printMatchTicketCount(Count matchTicketCount, LottoMatchCount lottoMatchCount) {
        System.out.println(lottoMatchCount.value() + "개 일치 (" + LottoPrize.moneyOf(lottoMatchCount) + "원)- " + matchTicketCount + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
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

    public void printLottoResult(LottoResult lottoResult) {
        printMatchTicketCount(lottoResult.ticketCountOf(LottoPrize.FIFTH), LottoPrize.matchCountOf(LottoPrize.FIFTH));
        printMatchTicketCount(lottoResult.ticketCountOf(LottoPrize.FOURTH), LottoPrize.matchCountOf(LottoPrize.FOURTH));
        printMatchTicketCount(lottoResult.ticketCountOf(LottoPrize.THIRD), LottoPrize.matchCountOf(LottoPrize.THIRD));
        printMatchTicketCount(lottoResult.ticketCountOf(LottoPrize.SECOND), LottoPrize.matchCountOf(LottoPrize.SECOND));
        printMatchTicketCount(lottoResult.ticketCountOf(LottoPrize.FIRST), LottoPrize.matchCountOf(LottoPrize.FIRST));
    }
}
