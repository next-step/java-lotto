package lotto.tool;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<LottoTicket> issueTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new LottoTicket(LottoAutoGenerator.random()));
        }
        return lottoTickets;
    }
}
