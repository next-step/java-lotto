package lotto.view;

import java.util.List;

import lotto.domain.LottoMchine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class ResultView {

    public static void renderBuyedTickets(List<LottoTicket> tickets) {
        System.out.println(String.format("%d개를 구매했습니다.", tickets.size()));
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public static void renderStats(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int i = 3; i < 7; i++) {
            System.out.println(String.format("%d개 일치 (%d원)- %d개", i, LottoMchine.getPrize(i), lottoResult.getCountByMatchCount(i)));
        }

        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lottoResult.getRatePercent()));
    }
}
