package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    private final ManualNumbers manualNumbers;
    private final PurchaseAmount purchaseAmount;
    private LottoNumbers lottoNumbers = LottoNumbers.newInstance();

    public LottoGame(PurchaseAmount purchaseAmount, ManualNumbers manualNumbers) {
        validatePurchaseAmount(purchaseAmount);
        validateManualNumbers(manualNumbers, purchaseAmount);

        this.purchaseAmount = purchaseAmount;
        this.manualNumbers = manualNumbers;
    }

    private void validatePurchaseAmount(PurchaseAmount purchaseAmount) {
        if (purchaseAmount == null) {
            throw new IllegalArgumentException("구입금액이 존재하지 않습니다.");
        }
    }

    private void validateManualNumbers(ManualNumbers manualNumbers, PurchaseAmount purchaseAmount) {
        if (manualNumbers == null) {
            throw new IllegalArgumentException("수동 로또 번호가 존재하지 않습니다.");
        }

        if (manualNumbers.getCount() > purchaseAmount.calculatePurchaseCount()) {
            throw new IllegalArgumentException("수동 로또 수가 총 로또 구매 수보다 많습니다.");
        }
    }

    public LottoNumbers createLottoNumbers() {
        createManualLottoNumbers();
        createAutoLottoNumbers();

        return this.lottoNumbers.clone();
    }

    private void createManualLottoNumbers() {
        List<LottoNumber> manualLottoNumbers = this.manualNumbers.stream()
                .map(LottoNumberFactory::createManualLottoNumbers)
                .collect(Collectors.toList());

        this.lottoNumbers.addAll(manualLottoNumbers);
    }

    private void createAutoLottoNumbers() {
        int autoLottoCount = getAutoLottoCount();

        List<LottoNumber> autoLottoNumbers = Stream.generate(LottoNumberFactory::createAutoLottoNumbers)
                .limit(autoLottoCount)
                .collect(Collectors.toList());

        this.lottoNumbers.addAll(autoLottoNumbers);
    }

    private int getAutoLottoCount() {
        return this.purchaseAmount.calculatePurchaseCount() - this.manualNumbers.getCount();
    }

    public LottoMatchResult calculateMatchCount(LottoNumber lastWinLottoNumber, BonusNumber bonusNumber) {
        return this.lottoNumbers.calculateMatchCount(lastWinLottoNumber, bonusNumber);
    }
}
