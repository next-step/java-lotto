package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoPackage {

    private List<LottoTicket> lottoTickets;

    public LottoPackage(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Integer> matchCount(LottoTicket winningTicket) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchNumbers(winningTicket))
                .sorted()
                .collect(toList());
    }

    public LottoMatchResult matchResult(LottoTicket winningTicket, int money) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchNumbers2(winningTicket))
                .collect(collectingAndThen(toList(), list -> new LottoMatchResult(list, money)));
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
