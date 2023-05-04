package step2.view;

import step2.domain.entity.LottoTickets;
import step2.domain.vo.LottoPrize;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printTickets(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        tickets.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLotto()));
    }

    public static void printWinnerStatistics(LottoTickets tickets, List<LottoPrize> lottoPrizes) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        printPrizeCount(tickets, lottoPrizes);

        System.out.println("총 수익률은 " + tickets.getTotalRate(lottoPrizes) + "입니다.");
    }

    private static void printPrizeCount(LottoTickets tickets, List<LottoPrize> lottoPrizes) {
        final var prizes = LottoPrize.values();
        final var fourthIndex = prizes.length - 2;
        final var firstIndex = 0;

        // 낙첨을 제외한 3개 일치(4등) ~ 6개 일치(1등) 까지 출력
        for (int i = fourthIndex; i >= firstIndex; i--) {
            final var prize = prizes[i];
            final var count = tickets.getLottoRankCount(prize, lottoPrizes);
            System.out.println(prize.getDescription() + " - " + count + "개");
        }
    }
}
