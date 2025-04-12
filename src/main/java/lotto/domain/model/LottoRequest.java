package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

public class LottoRequest {
    private final int purchaseAmount;
    private final List<List<Integer>> manualNumbersList = new ArrayList<>();

    public LottoRequest(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void addRequest(List<Integer> manualNumbers) {
        this.manualNumbersList.add(manualNumbers);
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public List<List<Integer>> getManualNumbersList() {
        return this.manualNumbersList;
    }

    public int getManualLottosCount() {
        return this.manualNumbersList.size();
    }

    public int getAutomaticLottosCount() {
        return (this.purchaseAmount - getManualLottosCount() * LOTTO_PRICE) / LOTTO_PRICE;
    }
}
