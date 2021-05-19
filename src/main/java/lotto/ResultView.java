package lotto;

import java.util.List;

public class ResultView {
    public void printLottoNumbers(List<LottoTicket> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).getLottoTicket());
        }
    }
}
