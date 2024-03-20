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
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<LottoTicket> tickets = Stream.generate(() -> new LottoTicket(lottoNumbers))
                .limit(count)
                .collect(Collectors.toList());
        return new LottoTickets(tickets);
    }

    public List<LottoTicket> get() {
        return this.lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
