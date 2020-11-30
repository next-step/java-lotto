package step4.lotto.domain;

import step4.lotto.util.LottoErrorMessage;

import java.util.Set;

public class LottoTicketCount {

    private static final int LOTTO_PRICE = 1000;

    private int lottoPurchaseAmount = 0;
    private int lottoAutoBuyCount = 0;
    private int lottoManualBuyCount = 0;

    public LottoTicketCount(int purchaseAmount, int lottoManualBuyCount) {
        checkPurchase(purchaseAmount);

        this.lottoPurchaseAmount = purchaseAmount;
        this.lottoAutoBuyCount = (purchaseAmount / LOTTO_PRICE) - lottoManualBuyCount;
        this.lottoManualBuyCount = lottoManualBuyCount;
    }

    private void checkPurchase(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new RuntimeException(LottoErrorMessage.getLottoAmountCheck());
        }
    }

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public int getLottoAutoBuyCount() {
        return lottoAutoBuyCount;
    }

    public int getLottoManualBuyCount() {
        return lottoManualBuyCount;
    }


    private void checkLottoManualBuyCount(int lottoManualBuyCount, int purchaseAmount) {
        if ((lottoManualBuyCount * LOTTO_PRICE) > purchaseAmount) {
            throw new RuntimeException(LottoErrorMessage.getLottoManualBuyCountCheck());
        }
    }
}
