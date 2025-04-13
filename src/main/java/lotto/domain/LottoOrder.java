package lotto.domain;

import java.util.List;

public class LottoOrder {

    private final Count totalCount;
    private final LottoTickets manualTickets;

    public LottoOrder(Price totalAmount, List<LottoTicket> manualNumbers) {
        Count totalCount = totalAmount.calculateTicketCount();
        validate(totalCount, new Count(manualNumbers.size()));

        this.totalCount = totalCount;
        this.manualTickets = new LottoTickets(manualNumbers, true);
    }

    private void validate(Count totalCount, Count manualTicketCount) {
        if (totalCount.isLessThan(manualTicketCount)) {
            throw new IllegalArgumentException("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없습니다.");
        }
    }

    private Count getAutoTicketCount() {
        return totalCount.subtract(manualTickets.getManualTicketCount());
    }

    public LottoTickets createTickets() {
        LottoTickets tickets = LottoTicketMachine.purchase(getAutoTicketCount());
        return tickets.add(manualTickets);
    }
}
