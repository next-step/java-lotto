package lotto.domain;

import java.util.List;

public class LottoMachine {
    private final LottoGenerator generator = new LottoGenerator();

    public List<Lotto> buy(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int ticketCount = purchaseAmount / 1000;
        return generator.generate(ticketCount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위의 양수여야 합니다.");
        }
    }

}
