package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int buyCount) {
        List<LottoTicket> lottoTickets = Stream.iterate(0, buy -> buy + 1)
                .limit(buyCount)
                .map(buy -> LottoTicket.create())
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }

    public int number() {
        return lottoTickets.size();
    }

    public Stream<LottoTicket> stream() {
        return this.lottoTickets.stream();
    }
}
