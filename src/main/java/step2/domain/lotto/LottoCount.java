package step2.domain.lotto;

public class LottoCount {
    private final int purchasedAmount;
    private final int lottoPrice;
    private final int manualLottoCount;

    public LottoCount(int purchaseAmount, int lottoPrice, int manualLottoCount) {
        validatePurchaseParameters(purchaseAmount, lottoPrice, manualLottoCount);

        this.purchasedAmount = purchaseAmount;
        this.lottoPrice = lottoPrice;
        this.manualLottoCount = manualLottoCount;
    }

    private void validatePurchaseParameters(int purchaseAmount, int lottoPrice, int manualLottoCount) {
        if (isInvalidPurchaseAmount(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }

        if (isInvalidManualLottoCount(manualLottoCount, purchaseAmount / lottoPrice)) {
            String validationMessage = "수동 로또 개수는 0 이상의 정수이며 구매 금액 / 로또 가격 보다 작거나 같아야 합니다.";
            throw new IllegalArgumentException(validationMessage);
        }
    }

    public LottoContainer generateAutoLottoContainer(LottoGenerator lottoGenerator) {
        int count = this.purchasedAmount / this.lottoPrice;
        return new LottoContainer(count - manualLottoCount, lottoGenerator);
    }

    public double getWinningRate(long winningAmount) {
        return (double) winningAmount / this.purchasedAmount;
    }

    private boolean isInvalidManualLottoCount(int manualLottoCount, int maxAllowedCount) {
        return manualLottoCount < 0 || manualLottoCount > maxAllowedCount;
    }

    private boolean isInvalidPurchaseAmount(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
