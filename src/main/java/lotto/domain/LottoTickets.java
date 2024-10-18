package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets createByPrice(int price) {
        return new LottoTickets(Stream.generate(LottoTicket::new)
                                      .limit(calculateTicketCount(price))
                                      .collect(Collectors.toList()));
    }

    private static int calculateTicketCount(int price) {
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
