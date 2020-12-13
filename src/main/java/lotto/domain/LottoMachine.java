package lotto.domain;

import lotto.domain.numbers.LottoTicket;
import lotto.domain.numbers.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoTicketFactory lottoTicketFactory;
    private final int numberOfLottoTickets;

    public LottoMachine(int numberOfLottoTickets) {
        this.lottoTicketFactory = new LottoTicketFactory();
        this.numberOfLottoTickets = numberOfLottoTickets;
    }

    public LottoTickets makeLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int index = 0; index < numberOfLottoTickets; index++) {
            lottoTickets.add(lottoTicketFactory.makeLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }
}
