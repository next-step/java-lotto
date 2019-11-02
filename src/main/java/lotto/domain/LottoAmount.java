package lotto.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:36
 */
public class LottoAmount {

    private final static int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("건네주신 금액으로는 로또를 살 수 없습니다.");
        }

        this.amount = amount;
    }

    public int getPurchasedLottoCount() {
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
