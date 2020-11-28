package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.ProfitRule;

import java.util.List;

public class ResultView {
    public void printTickets(int tickets) {
        System.out.println(tickets + "개를 구매했습니다 :)");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers().toString()));
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (ProfitRule p :lottoResult.getResult().keySet()) {
            System.out.println(p.getDesc() + "(" + p.getProfit() + ")" + ": " + lottoResult.getResult().get(p));
        }
        System.out.println("총 수익률은 " + lottoResult.getProfit()/lottoResult.getPayment() + "입니다.");
    }
}
