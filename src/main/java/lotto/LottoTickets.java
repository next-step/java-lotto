package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int money) {
        this.lottoTickets = generateLottoTickets(money);
    }

    private List<LottoTicket> generateLottoTickets(int money) {
        int lottoTicketCount = money / LottoTicket.PRICE;

        return IntStream.range(0, lottoTicketCount)
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoTicketCount() {
        return lottoTickets.size();
    }
}
