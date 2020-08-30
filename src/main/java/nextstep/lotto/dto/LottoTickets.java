package nextstep.lotto.dto;

import nextstep.lotto.utils.LottoNumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets, int buyAutoAmount) {
        this.tickets = tickets;
        this.tickets.addAll(buyAutoTicket(buyAutoAmount));
    }

    public static LottoTickets create(List<LottoTicket> tickets, int buyAutoAmount) {
        return new LottoTickets(tickets, buyAutoAmount);
    }

    public List<LottoTicket> getAll() {
        return Collections.unmodifiableList(tickets);
    }

    public Map<LottoRank, Long> resultRank(final LottoWinnerNumbers winnerTicket) {
        return tickets.stream()
                .map(lottoTicket -> winnerTicket.matchCount(lottoTicket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<LottoTicket> buyAutoTicket(int buyAutoTicketCount) {
        return Stream.generate((LottoNumberUtil::generator))
                .limit(buyAutoTicketCount)
                .map(LottoTicket::create)
                .collect(Collectors.toList());
    }
}
