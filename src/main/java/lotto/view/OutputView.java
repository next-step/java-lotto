package lotto.view;

import lotto.domain.result.LottoPrize;
import lotto.domain.result.LottoResult;
import lotto.domain.ticket.LottoTickets;

public class OutputView {

    private OutputView() {
    }


    public static void printLottoTicketNumbers(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.count() + "개를 구매했습니다.");
        lottoTickets.getLottoTickets().forEach(System.out::println);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("--------");
        System.out.printf("3개 일치(5000원) - %d개%n", lottoResult.countTicketsBy(LottoPrize.FIFTH));
        System.out.printf("4개 일치(50000) - %d개%n", lottoResult.countTicketsBy(LottoPrize.FOURTH));
        System.out.printf("5개 일치(1500000) - %d개%n", lottoResult.countTicketsBy(LottoPrize.THIRD));
        System.out.printf("5개 일치, 보너스볼일치(30000000) - %d개%n", lottoResult.countTicketsBy(LottoPrize.SECOND));
        System.out.printf("6개 일치(2000000000) - %d개%n", lottoResult.countTicketsBy(LottoPrize.FIRST));
        System.out.println("총 수익률은 " + lottoResult.getRateOfProfit() + "입니다.");
    }
}
