package lotto.domain.model;

import java.util.Objects;

public class LottoMoney {

    public static final int LOTTO_PRICE = 1_000;
    public static final String CHANGE = "로또 1장 가격인 " + LOTTO_PRICE + "의 배수로 금액을 입력해 주십시오.";
    public static final String NEGATIVE_AMOUNT = "구입 금액은 양수이어야만 합니다.";

    private final int amount;

    private LottoMoney(int amount) {
        this.amount = amount;
        validateNonNegative(amount);
        validateExactAmount(amount);
    }

    public static LottoMoney valueOf(int amount) {
        return new LottoMoney(amount);
    }

    public int numberOfTickets() {
        return amount / LOTTO_PRICE;
    }

    private static void validateNonNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT);
        }
    }

    private static void validateExactAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(CHANGE);
        }
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoMoney)) {
            return false;
        }
        LottoMoney money = (LottoMoney) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
