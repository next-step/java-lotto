package lotto.domain;

import lotto.domain.numbers.LottoTicket;
import lotto.domain.numbers.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoTicketFactory lottoTicketFactory;
    private final int countOfAutoLottoTickets;

    public LottoMachine(final int countOfAutoLottoTickets) {
        this.lottoTicketFactory = new LottoTicketFactory();
        this.countOfAutoLottoTickets = countOfAutoLottoTickets;
    }

    public LottoTickets makeAutoLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int index = 0; index < countOfAutoLottoTickets; index++) {
            lottoTickets.add(lottoTicketFactory.makeAutoLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }
}
