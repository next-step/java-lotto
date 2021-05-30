package lotto.domains;

public class LottoCount {

    private final int count;

    public LottoCount(int count) {
        validateGreaterThanZero(count);
        this.count = count;
    }

    public LottoCount(int count, Cash purchasingAmount) {
        validateSmallerThanNumberOfPurchasesAvailable(count, purchasingAmount);
        this.count = count;
    }

    private void validateSmallerThanNumberOfPurchasesAvailable(int count, Cash purchasingAmount) {
        if (purchasingAmount.isPurchasesAvailable(count)) {
            throw new IllegalArgumentException("구입가능 금액을 벗어납니다.");
        }
    }

    private void validateGreaterThanZero(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("0이상의 수를 입력해주세요");
        }
    }

    public int count() {
        return this.count;
    }
}
