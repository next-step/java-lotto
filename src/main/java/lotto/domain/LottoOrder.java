package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoOrder {

    private final Count totalCount;
    private final Count manualTicketCount;
    private final List<LottoTicket> manualTickets;

    public LottoOrder(int totalAmount, int manualTicketCount) {
        this(new Price(totalAmount), new Count(manualTicketCount), new ArrayList<>());
    }

    public LottoOrder(Price totalAmount, Count manualTicketCount, List<LottoTicket> manualNumbers) {
        Count totalCount = calculateTicketCount(totalAmount);

        validate(totalCount, manualTicketCount);
        this.totalCount = totalCount;
        this.manualTicketCount = manualTicketCount;
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
        return totalCount.subtract(manualTicketCount);
    }

    public Count getManualTicketCount() {
        return manualTicketCount;
    }

    public LottoTickets getTickets() {
        List<LottoTicket> tickets = manualTickets;
        tickets.addAll(LottoTicketMachine.purchase(getAutoTicketCount()).getTickets());
        return new LottoTickets(tickets);
    }
}
