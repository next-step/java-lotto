package lotto.view;

import lotto.domain.LotteryTicket;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by yusik on 2019/11/05.
 */
public class ResultView {

    private final PrintStream out;

    public ResultView(PrintStream out) {
        this.out = out;
    }

    public void showTickets(List<LotteryTicket> tickets) {
        out.println(tickets.size() + "개를 구매했습니다.");
        for (LotteryTicket ticket : tickets) {
            out.println(ticket.getNumbers());
        }
    }

    public void showStatistics() {
        out.println("당첨 통계\n---------");
        out.println(
                "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "6개 일치 (2000000000원)- 0개"
        );

        out.println("총 수익률은 0.35입니다.");
    }
}
