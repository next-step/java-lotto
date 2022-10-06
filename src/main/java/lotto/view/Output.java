package lotto.view;

import java.util.List;
import java.util.Set;

public class Output {

    public void printLottoTickets(List<Set> lottoTickets) {
        for (Set lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }
}
