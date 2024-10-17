package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(int price) {
        this.lottoTickets = generateLottoTickets(price);
    }

    private List<LottoTicket> generateLottoTickets(int price) {
        int ticketCount = calculateTicketCount(price);
        return Stream.generate(LottoTicket::new)
                     .limit(ticketCount)
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

    public List<Winning> calculateWinningResults(LottoTicket winningNumbers) {
        return lottoTickets.stream()
                           .map(ticket -> Winning.fromMatchCount(ticket.matchCount(winningNumbers)))
                           .collect(Collectors.toList());
    }
}
