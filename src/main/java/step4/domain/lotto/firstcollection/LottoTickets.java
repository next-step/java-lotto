package step4.domain.lotto.firstcollection;

import step4.Constant;
import step4.domain.lotto.LottoTicket;
import step4.domain.lotto.WinningNumbers;
import step4.type.LottoType;
import step4.type.WinningType;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public int countTickets() {
        return tickets.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        tickets.forEach(ticket -> sb.append(ticket.toString())
                .append(System.lineSeparator())
        );

        return sb.toString();
    }

    public Map<WinningType, Long> countByWinningType(WinningNumbers winningNumbers) {
        return tickets.stream()
                .map(ticket -> ticket.compareWinningNumber(winningNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public long countTicketByLottoType(LottoType type) {
        return tickets.stream()
                .filter(ticket-> ticket.equalsType(type))
                .count();
    }

    public double getExpenses() {
        return tickets.size() * Constant.LOTTO_PRICE;
    }
}
