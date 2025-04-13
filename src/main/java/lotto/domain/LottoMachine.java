package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;
    private final LottoGenerator generator = new LottoGenerator();

    public LottoPurchase buy(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int ticketCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> autoLottoList = generator.generate(ticketCount);
        return new LottoPurchase(purchaseAmount, ticketCount, 0, ticketCount, autoLottoList);
    }

    public LottoPurchase buy(int purchaseAmount, List<List<Integer>> manualNumbers) {
        validatePurchaseAmount(purchaseAmount);
        int totalTicketCount = purchaseAmount / LOTTO_PRICE;
        int manualTicketCount = manualNumbers.size();
        int autoTicketCount = totalTicketCount - manualTicketCount;

        List<Lotto> autoLottoList = generator.generate(autoTicketCount);
        List<Lotto> manualLottoList = generator.generate(manualNumbers);

        List<Lotto> totalLottoList = new ArrayList<>();
        totalLottoList.addAll(manualLottoList);
        totalLottoList.addAll(autoLottoList);

        return new LottoPurchase(purchaseAmount, totalTicketCount, manualTicketCount, autoTicketCount, totalLottoList);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위의 양수여야 합니다.");
        }
    }

}
