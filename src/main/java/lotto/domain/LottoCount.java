package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private static final int PRICE_PER_LOTTO = 1000;
    private final int count;

    public LottoCount(String count) {
        this(Integer.parseInt(count));
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public LottoCount increase() {
        return new LottoCount(this.count + 1);
    }

    public boolean isCountSame(int count) {
        return this.count == count;
    }

    private static int calculateLottoCount(int purchaseAmount) {
        if (purchaseAmount < PRICE_PER_LOTTO) {
            throw new RuntimeException("로또를 구매할 수 없는 가격입니다.");
        }

        return purchaseAmount / PRICE_PER_LOTTO;
    }

    public static LottoCount getAutoCount(String purchaseAmountInput, String manualCountInput) {
        return getAutoCount(Integer.parseInt(purchaseAmountInput), Integer.parseInt(manualCountInput));
    }

    private static LottoCount getAutoCount(int purchaseAmount, int manualCount) {
        int totalLottoCount = calculateLottoCount(purchaseAmount);
        if (!validateLottoCount(totalLottoCount, manualCount)) {
            throw new RuntimeException("수동 개수가 전체 로또 개수보다 많습니다.");
        }

        return new LottoCount(totalLottoCount - manualCount);
    }

    private static boolean validateLottoCount(int totalCount, int manualCount) {
        return totalCount >= manualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
