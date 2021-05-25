package lotto.domain;

import java.util.Objects;

public class LottoMoney {
    private static final int ZERO_WON = 0;
    private final int value;

    public LottoMoney(int amount) {
        validate(amount);

        this.value = amount;
    }

    private static void validate(int amount) {
        if (isLessThanZeroWon(amount)) {
            throw new IllegalArgumentException("로또구매금액은 0원 보다 작을 수 없습니다.");
        }
        if (!isValidUnit(amount)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구매할 수 있습니다");
        }
    }

    private static boolean isLessThanZeroWon(int amount) {
        return amount < ZERO_WON;
    }

    private static boolean isValidUnit(int amount) {
        return amount % Lotto.PRICE == 0;
    }

    public int countAffordableLotto() {
        return value / Lotto.PRICE;
    }

    public void checkAffordable(int countOfLotto) {
        if (!isAffordable(countOfLotto)) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    private boolean isAffordable(int countOfManualLotto) {
        return countOfManualLotto <= countAffordableLotto();
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
