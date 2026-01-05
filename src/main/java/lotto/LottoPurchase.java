package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record LottoPurchase(BigDecimal amount) {

    static void validate(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(1000)) < 0) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1,000원 이상이어야 합니다.");
        }

        if (amount.remainder(BigDecimal.valueOf(1000)).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int size() {
        return amount.divide(BigDecimal.valueOf(1000), RoundingMode.DOWN).intValueExact();
    }

    public void validateManualCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("수동 구매 수는 음수일 수 없습니다.");
        }
        if (count > size()) {
            throw new IllegalArgumentException("수동 구매 수가 총 구매 가능 수를 초과할 수 없습니다.");
        }
    }
}
