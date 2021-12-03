package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public int getTicketSize() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int getTotalPrice() {
        return tickets.size() * LottoTicket.PRICE;
    }

    public GameResult result(ResultLotto resultLotto) {
        return GameResult.create(
            tickets.stream()
                .map(resultLotto::award)
                .collect(Collectors.groupingBy(award -> award, Collectors.counting())),
            getTotalPrice());
    }

}
