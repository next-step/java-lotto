package lotto.domain;

public class LottoPurchase {

    private static final int TICKET_PRICE = 1000;

    private int purchaseAmount;
    private int autoPurchaseCount;
    private int manualPurchaseCount;

    private LottoPurchase(int autoPurchaseCount, int manualPurchaseCount, int purchaseAmount) {
        this.autoPurchaseCount = autoPurchaseCount;
        this.manualPurchaseCount = manualPurchaseCount;
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoPurchase purchase(int purchaseAmount, int numberPickedTickets) {

        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException("로또를 구매하기 적절한 금액이 아닙니다: " + purchaseAmount);
        }

        int all = purchaseAmount / TICKET_PRICE;
        int numberAutoCreatedTickets = all - numberPickedTickets;

        if (numberAutoCreatedTickets <= 0) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 개수를 넘었습니다: " + numberPickedTickets);
        }

        return new LottoPurchase(numberAutoCreatedTickets, numberPickedTickets, purchaseAmount);
    }

    public int getAutoPurchaseCount() {
        return autoPurchaseCount;
    }

    public int getManualPurchaseCount() {
        return manualPurchaseCount;
    }
}
