package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final LottoTicketFactory lottoTicketFactory;
    private final int numberOfLottoTickets;

    public LottoMachine(int numberOfLottoTickets) {
        this.lottoTicketFactory = new LottoTicketFactory();
        this.numberOfLottoTickets = numberOfLottoTickets;
    }

    public LottoTickets makeLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        IntStream.range(0, numberOfLottoTickets)
                .forEach(i -> lottoTickets.add(lottoTicketFactory.makeLottoTicket()));
        return new LottoTickets(lottoTickets);
    }
}
