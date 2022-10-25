package lotto.domain;

import java.util.Objects;

public class LottoAmount {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final String INVALID_PRICE_PER_PIECE_MESSAGE = PRICE_PER_LOTTO + "원 단위로 입력해주세요.";
    private static final String INVALID_PRICE_FOR_PURCHASE_MESSAGE =
            "로또를 구입하려면 1장에 " + PRICE_PER_LOTTO + "원 입니다. " + INVALID_PRICE_PER_PIECE_MESSAGE;

    private final int amount;

    public LottoAmount(String amount) {
        this(toInt(amount));
    }

    public LottoAmount(int amount) {
        this.amount = validateAmount(amount);
    }

    public int calcLottoCount() {
        return amount / PRICE_PER_LOTTO;
    }

    public double calcSumWinningMoneyRate(final double sumWinningMoney) {
        return Math.round(sumWinningMoney / amount * 100) / 100.0;
    }

    private static int validateAmount(int amount) {
        if (amount < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(INVALID_PRICE_FOR_PURCHASE_MESSAGE);
        }
        if (amount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_PER_PIECE_MESSAGE);
        }
        return amount;
    }

    private static int toInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new NumberFormatException(NOT_NUMBER_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAmount that = (LottoAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
