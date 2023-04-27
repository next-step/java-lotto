package step2;

import java.util.List;

public class ResultView {

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(System.out::println);
    }
}
