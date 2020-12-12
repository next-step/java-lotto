package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class LottoMachine {
    private static final int MONEY_OF_ONE_TICKET = 1000;

    private final LottoTicketFactory lottoTicketFactory;
    private final long numberOfLottoTickets;

    public LottoMachine(long money) {
        this.lottoTicketFactory = new LottoTicketFactory();
        this.numberOfLottoTickets = money / MONEY_OF_ONE_TICKET;
    }

    public LottoTickets makeLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LongStream.range(0, numberOfLottoTickets)
                .forEach(i -> lottoTickets.add(lottoTicketFactory.makeLottoTicket()));
        return new LottoTickets(lottoTickets);
    }
}
