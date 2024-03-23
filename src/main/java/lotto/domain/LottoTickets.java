package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets auto(int count) {
        List<LottoTicket> tickets = Stream.generate(LottoTicket::new)
                .limit(count)
                .collect(Collectors.toUnmodifiableList());
        return new LottoTickets(tickets);
    }

    public List<LottoTicket> get() {
        return this.lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
