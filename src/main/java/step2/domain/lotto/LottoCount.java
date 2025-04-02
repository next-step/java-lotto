package step2.domain.lotto;

public class LottoCount {
    private final int purchasedAmount;
    private final int lottoPrice;

    public LottoCount(int purchaseAmount, int lottoPrice) {
        if (isValid(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }
        this.purchasedAmount = purchaseAmount;
        this.lottoPrice = lottoPrice;
    }

    public LottoContainer generateLottoContainer(LottoGenerator lottoGenerator) {
        int count = this.purchasedAmount / this.lottoPrice;
        return new LottoContainer(count, lottoGenerator);
    }

    public double getWinningRate(long winningAmount) {
        return (double) winningAmount / this.purchasedAmount;
    }

    private boolean isValid(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
