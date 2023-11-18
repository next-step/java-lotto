package lotto.domain;

import java.util.Objects;

public class LottoAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int REMAIN = 0;
    private int amount;

    public LottoAmount(String amount) {
        int value = validateType(amount);
        validateUnit(value);
        this.amount = value;
    }

    private int validateType(String amount) {
        int value = 0;
        try {
            value = Integer.parseInt(amount);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return value;
    }

    private void validateUnit(int value) {
        if (value % LOTTO_PRICE != REMAIN) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public int findLottoCount() {

        return amount / LOTTO_PRICE;
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
