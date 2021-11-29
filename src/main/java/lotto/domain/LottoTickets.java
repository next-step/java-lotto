package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;
    private final int price;

    public LottoTickets(List<LottoTicket> tickets, int price) {
        this.tickets = tickets;
        this.price = price;
    }

    public int getTicketSize() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int getTotalPrice() {
        return tickets.size() * price;
    }

    public GameResult result(ResultLotto resultLotto) {
        return GameResult.create(
            tickets.stream()
                .map(resultLotto::award)
                .collect(Collectors.groupingBy(award -> award, Collectors.counting())),
            getTotalPrice());
    }

}
