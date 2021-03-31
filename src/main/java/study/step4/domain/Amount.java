package study.step4.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Amount(String amount) {
        this(Integer.parseInt(amount));
    }

    public Amount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    private void valid(int amount) {
        if ((amount < 0) || (amount % LOTTO_PRICE != 0)) {
            throw new IllegalArgumentException("로또 구매 최저 금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    public int totalCount() {
        return amount / LOTTO_PRICE;
    }

    public int buyableCount(LottoTicketCount manualCount) {
        int ticketCount = totalCount() - manualCount.getLottoTicketCount();
        if (ticketCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 로또 수가 구입금액 보다 큽니다.");
        }
        return ticketCount;
    }

    public int getAmount() {
        return amount;
    }
}
