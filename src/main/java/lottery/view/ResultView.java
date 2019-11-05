package lottery.view;

import java.util.List;
import lottery.LottoTicket;

public class ResultView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        int numberOfTickers = lottoTickets.size();
        System.out.println(numberOfTickers + "개를 구매했습니다.");

        lottoTickets
            .forEach(lottoTicket -> System.out.println("[" + lottoTicket.toString() + "]"));
    }
}
