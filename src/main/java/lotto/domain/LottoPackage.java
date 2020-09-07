package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPackage {

    private List<LottoTicket> lottoTickets;

    public LottoPackage(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Integer> matchCount(LottoTicket winningTicket) {
        return lottoTickets.stream()
              .map(lottoTicket -> lottoTicket.matchNumbers(winningTicket))
              .sorted()
              .collect(Collectors.toList());
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
