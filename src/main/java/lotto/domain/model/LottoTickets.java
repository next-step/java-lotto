package lotto.domain.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.LottoTicketDto;

public class LottoTickets {

    private final List<LottoTicket> ticketList;

    private LottoTickets(List<LottoTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public static LottoTickets of(List<LottoTicket> ticketList) {
        return new LottoTickets(ticketList);
    }

    public LottoResult match(LottoTicket winningTicket) {
        Map<LottoRank, Integer> rankToCount = ticketList.stream()
                .map(ticket -> ticket.findRank(winningTicket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
        return LottoResult.of(rankToCount);
    }

    public List<LottoTicketDto> getTickets() {
        return ticketList.stream()
                .map(LottoTicketDto::of)
                .collect(Collectors.toList());
    }

    public int size() {
        return ticketList.size();
    }
}
