package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoOrder {

    private final Count totalCount;
    private final List<LottoTicket> manualTickets;

    public LottoOrder(Price totalAmount, List<LottoTicket> manualNumbers) {
        Count totalCount = calculateTicketCount(totalAmount);

        validate(totalCount, new Count(manualNumbers.size()));
        this.totalCount = totalCount;
        this.manualTickets = manualNumbers;
    }

    private void validate(Count totalCount, Count manualTicketCount) {
        if (totalCount.isLessThan(manualTicketCount)) {
            throw new IllegalArgumentException("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없습니다.");
        }
    }

    private Count calculateTicketCount(Price price) {
        return price.calculateTicketCount();
    }

    public Count getAutoTicketCount() {
        return totalCount.subtract(new Count(manualTickets.size()));
    }

    public Count getManualTicketCount() {
        return new Count(manualTickets.size());
    }

    public LottoTickets createTickets() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.addAll(manualTickets);
        tickets.addAll(LottoTicketMachine.purchase(getAutoTicketCount()).getTickets());
        return new LottoTickets(tickets);
    }
}
