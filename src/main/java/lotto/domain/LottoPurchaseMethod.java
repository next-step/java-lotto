package lotto.domain;

public class LottoPurchaseMethod {

    private final Positive lottoCount;
    private final NonNegative manualCount;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchaseMethod(int purchaseMoney, int manualCount) {
        this.lottoCount = new Positive(purchaseMoney / LOTTO_PRICE);
        this.manualCount = new NonNegative(manualCount);
        validate();
    }

    private void validate() {

        if (this.lottoCount.isLessThan(this.manualCount)) {
            throw new IllegalArgumentException("수동 방식 횟수가 로또 구매량보다 많습니다.");
        }
    }

    public int autoCount() {
        return this.lottoCount.minus(this.manualCount);
    }

    public int getManualCount() {
        return this.manualCount.getNumber();
    }

}

