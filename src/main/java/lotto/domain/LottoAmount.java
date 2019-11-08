package lotto.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:19
 */
public class LottoAmount {

    private final static int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입하려면 최소 1000원이 필요합니다.");
        }
        this.amount = amount;
    }

    public int amount() {
        return amount / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAmount amount1 = (LottoAmount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
