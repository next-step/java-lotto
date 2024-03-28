package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;

public class OutputView {

    public void displayLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void displayWinning(Map<LottoPrice, Integer> results) {
        System.out.println("당첨 통계");

        for (Map.Entry<LottoPrice, Integer> item : results.entrySet()) {
            if (item.getKey() != LottoPrice.MISS) {
                System.out.printf("%d개 일치 %s (%d원)- %d개", item.getKey().getCount(),
                    item.getKey().isBonusResult() ? ", 보너스 볼 일치" : "",
                    item.getKey().getPrice(), item.getValue());
            }
            System.out.println();
        }
    }

    public void displayWinningMoney(double returnRate) {

        System.out.printf("총 수익률은 %.2f입니다.", returnRate);
    }
}
