package lotto.domain;

import lotto.exception.InvalidManualLottoCountException;

import java.util.List;

public class LottoMachine {

    static final int PRICE_OF_LOTTO = 1000;

    private int purchaseLottoCount;
    private int purchaseAmount;

    public LottoMachine(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseLottoCount = purchaseAmount / PRICE_OF_LOTTO;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public LottoTicket generateLottoTicket(List<Integer> randomLottoTicket) {
        return LottoTicket.of(randomLottoTicket);
    }

    public void validManualCount(int manualLottoCount) {
        if (PRICE_OF_LOTTO * manualLottoCount > purchaseAmount) {
            throw new InvalidManualLottoCountException();
        }
    }
}
