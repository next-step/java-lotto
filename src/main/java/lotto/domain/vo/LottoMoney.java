package lotto.domain.vo;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final int numberOfTicket;

    public LottoMoney(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.numberOfTicket = purchaseAmount / LOTTO_PRICE;
    }

    public double calculateRateOfReturn(int profit) {
        double rateOfReturn = (double) profit / purchaseAmount;

        return rateOfReturn;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }
}
