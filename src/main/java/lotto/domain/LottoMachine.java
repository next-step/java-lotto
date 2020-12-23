package lotto.domain;

import lotto.domain.numbers.LottoTicket;
import lotto.domain.numbers.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final AutoLottoTicketFactory autoLottoTicketFactory;
    private final int countOfAutoLottoTickets;

    public LottoMachine(final int countOfAutoLottoTickets) {
        this.autoLottoTicketFactory = new AutoLottoTicketFactory();
        this.countOfAutoLottoTickets = countOfAutoLottoTickets;
    }

    public LottoTickets makeAutoLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int index = 0; index < countOfAutoLottoTickets; index++) {
            lottoTickets.add(autoLottoTicketFactory.makeAutoLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }
}
