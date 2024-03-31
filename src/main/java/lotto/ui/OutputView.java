package lotto.ui;

import java.util.List;
import lotto.LottoResultManager;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;

public class OutputView {

    public void displayLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void displayWinning(LottoResultManager lottoResultManager) {
        System.out.println("당첨 통계");
        for (LottoPrice price : LottoPrice.values()) {
            displayDetailResult(lottoResultManager, price);
        }

    }

    private static void displayDetailResult(LottoResultManager lottoResultManager,
        LottoPrice price) {
        if (price != LottoPrice.MISS) {
            System.out.printf("%d개 일치 %s (%d원)- %d개", price.getCount(),
                price.isBonusResult() ? ", 보너스 볼 일치" : "", price.getPrice(),
                lottoResultManager.getCount(price));
            System.out.println();
        }
    }

    public void displayWinningMoney(LottoResultManager lottoResultManager, int purchaseAmount) {

        System.out.printf("총 수익률은 %.2f입니다.",
            lottoResultManager.calculateReturnRate(purchaseAmount));
    }
}
