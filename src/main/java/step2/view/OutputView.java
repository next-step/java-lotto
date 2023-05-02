package step2.view;

import step2.domain.vo.LottoPrize;
import step2.domain.entity.LottoTickets;

public class OutputView {

    private OutputView() {
    }

    public static void printTickets(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        tickets.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLotto()));
    }

    public static void printWinnerStatistics(LottoTickets tickets) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + tickets.getLottoRankCount(LottoPrize.FOURTH) + "개");
        System.out.println("4개 일치 (50000원) - " + tickets.getLottoRankCount(LottoPrize.THIRD) + "개");
        System.out.println("5개 일치 (1500000원) - " + tickets.getLottoRankCount(LottoPrize.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + tickets.getLottoRankCount(LottoPrize.FIRST) + "개");

        System.out.println("총 수익률은 " + tickets.getTotalRate() + "입니다.");
    }
}
