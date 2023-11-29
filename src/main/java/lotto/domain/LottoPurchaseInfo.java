package lotto.domain;

// 개선 필요
public class LottoPurchaseInfo {
    private static final Integer LOTTO_TICKET_PRICE = 1000;

    private final int totalAmount;

    private final int manualQuantity;

    public LottoPurchaseInfo(int totalAmount, int manualQuantity) {
        this.totalAmount = totalAmount;
        this.manualQuantity = manualQuantity;

        validTicket();
        validTotalIsGreaterThanManual();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }

    public int calcTotalQuantity() {
        return totalAmount / LOTTO_TICKET_PRICE;
    }

    private void validTicket() {
        if (totalAmount < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("로또는 최소 한장이상 구매할 수 있습니다.");
        }
    }

    public int calcAutoQuantity() {
        return calcTotalQuantity() - manualQuantity;
    }

    private void validTotalIsGreaterThanManual() {
        if (calcTotalQuantity() < manualQuantity) {
            throw new IllegalArgumentException("수동 구매 개수는 총 로또 구매 개수보다 클 수 없습니다.");
        }
    }
}
