package lotto.domain;

public class LottoMachine {

    private static final int TICKET_PRICE = 1000;
    private final NumberGenerationStrategy numberGenerationStrategy;

    public LottoMachine(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public LottoTickets issue(int purchaseAmount) {
        int purchaseQuantity = this.calculatePurchaseQuantity(purchaseAmount);
        return new LottoTickets(purchaseQuantity, numberGenerationStrategy);
    }

    private int calculatePurchaseQuantity(int purchaseAmount) {

        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException("로또를 구매하기 적절한 금액이 아닙니다: " + purchaseAmount);
        }

        return purchaseAmount/TICKET_PRICE;
    }
}
