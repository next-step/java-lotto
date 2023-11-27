package lotto;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 금액은 1000원 단위어야 합니다");
        }
    }

    public int purchaseAmount() {
        return this.purchaseAmount;
    }

    public int lottoCount() {
        return this.purchaseAmount / 1000;
    }

    public int automaticLottoCount(int manualLottoCount) {
        int automaticLottoCount = this.lottoCount() - manualLottoCount;
        checkLottoCountIsValid(automaticLottoCount);

        return automaticLottoCount;
    }

    private void checkLottoCountIsValid(int automaticLottoCount) {
        if(automaticLottoCount < 0) {
            throw new IllegalArgumentException("유효한 범위의 수동로또, 자동로또 갯수를 입력하세요");
        }
    }
}
