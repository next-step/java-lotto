package lotto.domain;

import java.util.Objects;

public class LottoMoney {
    private final int value;

    public LottoMoney(int amount) {
        validate(amount);

        this.value = amount;
    }

    private static void validate(int amount) {
        if (isLessThanLottoPrice(amount)) {
            throw new IllegalArgumentException("로또 최소 구매액은 1000원 입니다.");
        }
        if (!isValidUnit(amount)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구매할 수 있습니다");
        }
    }

    private static boolean isLessThanLottoPrice(int amount) {
        return amount < Lotto.PRICE;
    }

    private static boolean isValidUnit(int amount) {
        return amount % Lotto.PRICE == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMoney that = (LottoMoney) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
