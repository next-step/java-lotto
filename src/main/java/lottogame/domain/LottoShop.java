package lottogame.domain;

import lottogame.controller.request.LottoPurchaseRequest;
import lottogame.domain.spi.NumberGenerator;

public class LottoShop {

    public LottoTickets purchase(LottoPurchaseRequest lottoPurchaseRequest, NumberGenerator numberGenerator) {
        assertMoney(lottoPurchaseRequest.getMoney());
        assertManualLottoCount(lottoPurchaseRequest);

        int totalLottoCount = lottoPurchaseRequest.getMoney() / LottoTicket.PURCHASABLE_UNIT;
        return new LottoTickets(totalLottoCount, lottoPurchaseRequest.getManualLottoNumbersList(), numberGenerator);
    }

    private void assertMoney(int money) {
        if (money % LottoTicket.PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", LottoTicket.PURCHASABLE_UNIT, money));
        }
    }

    private void assertManualLottoCount(LottoPurchaseRequest lottoPurchaseRequest) {
        if (lottoPurchaseRequest.getMoney() / LottoTicket.PURCHASABLE_UNIT < lottoPurchaseRequest.getManualLottoCount()) {
            throw new IllegalArgumentException(String.format("수동 갯수는 살 수 있는 양 \"%d\" 이상 구매할 수 없습니다. manualLottoCount: \"%d\"",
                    lottoPurchaseRequest.getMoney() / LottoTicket.PURCHASABLE_UNIT, lottoPurchaseRequest.getManualLottoCount()));
        }
    }
}
