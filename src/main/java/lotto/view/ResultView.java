package lotto.view;

import java.util.List;

import lotto.domain.*;

public class ResultView {

    public static void renderBuyedTickets(LottoTicket tickets) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                tickets.getManualLottoCount(),
                tickets.getManualLottoCount()));
        printLotto(tickets.getManualLottos());
        printLotto(tickets.getAutoLottos());
    }

    private static void printLotto(List<Lotto> manualLottos) {
        for (Lotto ticket : manualLottos) {
            System.out.println(ticket);
        }
    }

    public static void renderStats(Money won, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (LottoPrize prize:LottoPrize.valuesWithoutNone()) {
            String message = "%d개 일치 (%d원)- %d개";
            if (LottoPrize.SECOND == prize) {
                message = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
            }
            System.out.println(String.format(message, prize.getMatchCount(), prize.getPrize(), lottoResult.getCountByLottoPrize(prize)));
        }

        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", won.calcurateProfitRate(lottoResult.getTotalPrize())));
    }
}
