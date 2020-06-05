package lotto.domain.vo;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private int numberOfAutoTicket;
    private int numberOfManualTicket;

    public LottoMoney(int purchaseAmount, int numberOfManualTicket) {
        validatePurchaseAmount(purchaseAmount);
        validateNumberOfManualTicket(purchaseAmount, numberOfManualTicket);
        this.numberOfManualTicket = numberOfManualTicket;
        this.numberOfAutoTicket = purchaseAmount / LOTTO_PRICE - numberOfManualTicket;
    }

    public double calculateRateOfReturn(int profit) {
        int purchaseAmount = (numberOfAutoTicket + numberOfManualTicket) * LOTTO_PRICE;

        return profit / purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다. - " + purchaseAmount);
        }
    }

    private void validateNumberOfManualTicket(int purchaseAmount, int numberOfManualTicket) {
        if (purchaseAmount < LOTTO_PRICE * numberOfManualTicket) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 개수를 초과했습니다. - " + numberOfManualTicket);
        }
    }

    public int getNumberOfAutoTicket() {
        return numberOfAutoTicket;
    }

    public int getNumberOfManualTicket() {
        return numberOfManualTicket;
    }
}
