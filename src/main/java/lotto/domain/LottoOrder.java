package lotto.domain;

public class LottoOrder {

    public static final int PRICE_PER_TICKET = 1000;

    private final int totalCount;
    private final int manualTicketCount;

    public LottoOrder(int totalAmount, int manualTicketCount) {
        int totalCount = calculateTicketCount(totalAmount);

        validate(totalCount, manualTicketCount);
        this.totalCount = totalCount;
        this.manualTicketCount = manualTicketCount;
    }

    private void validate(int totalCount, int manualTicketCount) {
        if (totalCount <= 0) {
            throw new IllegalArgumentException("하나 이상의 티켓을 구매해야 합니다.");
        }

        if (manualTicketCount < 0) {
            throw new IllegalArgumentException("수동 구매 티켓 수는 0 이상이어야 합니다.");
        }
        if (manualTicketCount > totalCount) {
            throw new IllegalArgumentException("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없습니다.");
        }
    }

    private int calculateTicketCount(int price) {
        return price / PRICE_PER_TICKET;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getAutoTicketCount() {
        return totalCount - manualTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }
}
