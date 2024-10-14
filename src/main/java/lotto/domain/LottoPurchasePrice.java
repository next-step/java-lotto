package lotto.domain;

import java.util.Objects;

public class LottoPurchasePrice {
    private static final int PRICE = 1000;

    private final int value;

    private LottoPurchasePrice(int value) {
        validateInit(value);
        this.value = value;
    }

    public int getLottoCount() {
        return value / PRICE;
    }

    public int getValue() {
        return value;
    }

    public void validateLottoCount(final int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("수동 로또 발급 횟수는 음수일 수 없습니다.");
        }
        if (getLottoCount() - manualLottoCount < 0) {
            throw new IllegalArgumentException("로또 구매 금액보다 많은 양의 로또는 구매할 수 없습니다.");
        }
    }

    private void validateInit(int value) {
        validateNegative(value);
        validatePurchasePrice(value);
    }

    private void validateNegative(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("구매 금액은 0이거나 음수일 수 없습니다.");
        }
    }

    private void validatePurchasePrice(final int purchasePrice) {
        if (purchasePrice % PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPurchasePrice that = (LottoPurchasePrice) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static LottoPurchasePrice valueOf(int value) {
        return new LottoPurchasePrice(value);
    }
}
