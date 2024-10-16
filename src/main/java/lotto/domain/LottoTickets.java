package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int price) {
        this.lottoTickets = generateLottoTickets(price);
    }

    private List<LottoTicket> generateLottoTickets(int price) {
        int ticketCount = calculateTicketCount(price);
        return IntStream.range(0, ticketCount)
                        .mapToObj(i -> new LottoTicket())
                        .collect(Collectors.toList());
    }

    private int calculateTicketCount(int price) {
        return price / LottoTicket.PRICE;
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
