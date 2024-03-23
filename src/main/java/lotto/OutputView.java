package lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    private List<Integer> MONEY = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    public void displayLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            System.out.println(Arrays.deepToString(ticket.displayNumbers().toArray()));
        }
    }

    public void displayWinning(List<Integer> result, int purchaseAmount) {
        int winningAmount = 0;
        System.out.println("당첨 통계");
        for (int i = 3; i < result.size(); i++) {
            System.out.println(i + "개 일치 (" + MONEY.get(i) + ")-" + result.get(i) + "개");
            winningAmount += MONEY.get(i) * result.get(i);
        }
        System.out.printf("총 수익률은 %.3f입니다", (double) winningAmount / purchaseAmount);
    }
}
