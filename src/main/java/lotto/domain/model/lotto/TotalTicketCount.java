package lotto.domain.model.lotto;

public class TotalTicketCount {

    private final TicketCount totalTicketCount;
    private final TicketCount autoTicketCount;
    private final TicketCount manualTicketCount;

    public TotalTicketCount(final TicketCount totalTicketCount, final TicketCount manualTicketCount) {
        validate(totalTicketCount, manualTicketCount);
        this.totalTicketCount = totalTicketCount;
        this.manualTicketCount = manualTicketCount;
        this.autoTicketCount = totalTicketCount.substract(manualTicketCount.getCount());
    }

    private void validate(final TicketCount totalTicketCount, final TicketCount manualTicketCount) {
        if (totalTicketCount.getCount() < manualTicketCount.getCount()) {
            throw new IllegalArgumentException("수동으로 구매하려는 로또 수가 총 구매 가능한 로또 수를 초과합니다.");
        }
    }

    public TicketCount getTotalTicketCount() {
        return totalTicketCount;
    }

    public TicketCount getAutoTicketCount() {
        return autoTicketCount;
    }

    public TicketCount getManualTicketCount() {
        return manualTicketCount;
    }
}
