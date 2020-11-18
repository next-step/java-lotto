package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    List<LottoTicket> lottoTickets;

    public LottoTickets(int gameMoney) {
        int ticketCount = gameMoney/1000;
        this.lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(ticket -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
