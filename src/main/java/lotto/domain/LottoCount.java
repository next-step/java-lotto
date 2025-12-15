package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private static final int PRICE_PER_LOTTO = 1000;
    private final int totalCount;
    private final int manualCount;


    public LottoCount(String purchaseAmount, String manualCount) {
        this(Integer.parseInt(purchaseAmount), Integer.parseInt(manualCount));
    }

    public LottoCount(int purchaseAmount, int manualCount) {
        if (!validateLottoCount(purchaseAmount / PRICE_PER_LOTTO, manualCount)) {
            throw new RuntimeException("유효하지 않은 로또 개수입니다.");
        }

        this.totalCount = purchaseAmount /  PRICE_PER_LOTTO;
        this.manualCount = manualCount;
    }

    private static boolean validateLottoCount(int totalCount, int manualCount) {
        return totalCount >= manualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return totalCount == that.totalCount && manualCount == that.manualCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCount, manualCount);
    }
}
