package step2.lotto.view;

import step2.lotto.model.Count;
import step2.lotto.model.LottoResult;
import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;
import step2.lotto.model.PrizeMoney;

public class ResultView {

    public void printLottoTicketCount(LottoTicketList lottoTicketList) {
        System.out.println(lottoTicketList.value().size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTicketList.value()) {
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

    public void printMatchTicketCount(Count matchTicketCount, Count matchCount) {
        System.out.println(matchCount + "개 일치 (" + PrizeMoney.of(matchCount).value() + "원)- " + matchTicketCount + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.print(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 ", rateOfReturn));
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
        printMatchTicketCount(lottoResult.match3LottoTicketCount(), new Count(3));
        printMatchTicketCount(lottoResult.match4LottoTicketCount(), new Count(4));
        printMatchTicketCount(lottoResult.match5LottoTicketCount(), new Count(5));
        printMatchTicketCount(lottoResult.match6LottoTicketCount(), new Count(6));
    }
}
