package lotto.domain;

import java.util.Objects;

public class LottoAmount {

    private int amount;

    public LottoAmount(String amount) {
        int value = 0;
        try {
            value = Integer.parseInt(amount);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (value % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
        this.amount = value;
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
