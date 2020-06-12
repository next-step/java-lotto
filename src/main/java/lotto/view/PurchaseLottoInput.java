package lotto.view;

import lotto.domain.LottoFactory;

import java.util.List;

public class PurchaseLottoInput {
    private final int purchasePrice;
    private final List<String> manualLottoNumbers;

    public PurchaseLottoInput(int purchasePrice, List<String> manualLottoNumbers) {
        validationCheck(purchasePrice, manualLottoNumbers);
        this.purchasePrice = purchasePrice;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<String> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    private void validationCheck(int purchasePrice, List<String> manualLottoNumbers) {
        if (purchasePrice < LottoFactory.PRICE) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상입니다.");
        }

        if (manualLottoNumbers == null || manualLottoNumbers.size() > purchasePrice / LottoFactory.PRICE) {
            throw new IllegalArgumentException("수동으로 구매할 로또 개수가 예산을 초과합니다.");
        }
    }

    public int getManualSize(){
        return manualLottoNumbers.size();
    }

    public int getAutoSize(){
        return (purchasePrice / LottoFactory.PRICE) - manualLottoNumbers.size();
    }
}
