package lotto.controller.generator;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;

public class AutoLottoTicketGenerator implements LottoTicketGenerator {
    public List<LottoTicket> createLottoTickets(int lottoTicketCount) {
        List<LottoTicket> autoLottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            autoLottoTickets.add(LottoTicket.createRandomNumber());
        }
        return autoLottoTickets;
    }
}
