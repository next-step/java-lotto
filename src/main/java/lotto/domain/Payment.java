package lotto.domain;

public class Payment {

    private final static int LOTTO_TICKET_PRICE = 1000;
    private final static int LOTTO_TICKET_BUY_MAX_PRICE = 100000;

    private final int amount;
    private final int manualCount;

    public Payment(final int amount, final int manualCount) {
        validateAmount(amount);
        validateManualCount(manualCount, amount);
        this.amount = amount;
        this.manualCount = manualCount;
    }

    public int amount() {
        return amount;
    }

    public int manualCount() {
        return manualCount;
    }

    public int automaticCount() {
        return (amount / LOTTO_TICKET_PRICE) - manualCount;
    }

    private void validateAmount(final int amount) {
        if (amount < LOTTO_TICKET_PRICE || amount > LOTTO_TICKET_BUY_MAX_PRICE) {
            throw new IllegalArgumentException("입력하신 금액이 올바르지 않습니다. (최소 금액:" + LOTTO_TICKET_PRICE + "원, 최대 금액:" + LOTTO_TICKET_BUY_MAX_PRICE + ")");
        }
    }

    private void validateManualCount(final int manualCount, final int amount) {
        if (manualCount > (amount / LOTTO_TICKET_PRICE) && manualCount > 0) {
            throw new IllegalArgumentException("수동 구매 로또의 수가 전체 구매 수량을 초과하였습니다.");
        }
    }
}
