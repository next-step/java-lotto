package lotto.view;

import lotto.domain.LottoFactory;

import java.util.List;

public class PurchaseLottoInput {
    private final int purchasePrice;
    private final List<String> manualLottoNumbers;

    public PurchaseLottoInput(int purchasePrice, List<String> manualLottoNumbers) {
        this.purchasePrice = purchasePrice;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<String> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public int getManualSize(){
        return manualLottoNumbers.size();
    }

    public int getAutoSize(){
        return (purchasePrice / LottoFactory.PRICE) - manualLottoNumbers.size();
    }
}
