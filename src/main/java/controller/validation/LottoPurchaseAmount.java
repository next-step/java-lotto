package controller.validation;

import java.util.Objects;

/**
 * 로또 금액 타입입니다.
 * 불변 객체입니다.
 */
public class LottoPurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int value;

    public LottoPurchaseAmount(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("0 또는 그 이상의 값을 원하나 입력된 값이 " + value + "입니다.");
        }
        this.value = value;
    }

    /**
     * 이 금액으로 살 수 있는 로또 장수를 계산합니다.
     * @return 로또 장수
     */
    public LottoCount calTotalLottoCount() {
        return new LottoCount(this.value / LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchaseAmount that = (LottoPurchaseAmount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "" + this.value;
    }

    public int toInt() {
        return this.value;
    }
}
