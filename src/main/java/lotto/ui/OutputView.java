package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;

public class OutputView {

    private List<Integer> MONEY = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    public void displayLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void displayWinning(Map<Integer, Integer> result) {
        System.out.println("당첨 통계");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int matchedNumbers = entry.getKey();
            if (matchedNumbers > 2) {
                int prize = MONEY.get(matchedNumbers);
                int count = entry.getValue();
                System.out.printf("%d개 일치 (%d원) - %d개\n", matchedNumbers, prize, count);
            }
        }
    }

    public void displayWinningMoney(double returnRate) {

        System.out.printf("총 수익률은 %.2f입니다", returnRate);
    }
}
