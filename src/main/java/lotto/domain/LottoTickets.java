package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    List<LottoTicket> lottoTickets;
    List<Integer> lotteNumbers;

    public LottoTickets(int gameMoney, List<Integer> lotteNumbers) {
        int ticketCount = gameMoney/1000;
        this.lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(ticket -> new LottoTicket(lotteNumbers))
                .collect(Collectors.toList());
        this.lotteNumbers = lotteNumbers;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
