package nextstep.lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets create(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public List<LottoTicket> getAll() {
        return Collections.unmodifiableList(tickets);
    }

    public Map<LottoRank, Long> matchCount(final LottoWinnerNumbers winnerTicket) {
        return tickets.stream()
                .map(lottoTicket -> winnerTicket.matchCount(lottoTicket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
