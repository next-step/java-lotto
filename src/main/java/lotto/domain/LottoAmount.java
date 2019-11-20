package lotto.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-20 20:46
 */
public class LottoAmount {

    private static final int LOTTO_PRICE = 1000;
    private int amount;

    public LottoAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입하려면 최소 1000원이 필요합니다.");
        }
        this.amount = purchaseAmount;
    }

    public int getAvailableLottoCount() {
        return this.amount / LOTTO_PRICE;
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
