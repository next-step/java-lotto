package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoOrder {

    private final Count totalCount;
    private final LottoTickets manualTickets;

    public LottoOrder(int totalAmount, List<List<Integer>> manualNumbers) {
        this(new Price(totalAmount), manualNumbers.stream().map(LottoTicket::new).collect(Collectors.toList()));
    }

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

    public Count getAutoTicketCount() {
        return totalCount.subtract(manualTickets.getManualTicketCount());
    }

    public LottoTickets getManualTickets() {
        return manualTickets;
    }
}
