package lotto.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:19
 */
public class LottoAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;
    private final int amount;
    private final int manualLottoCount;

    private LottoAmount(int amount) {
        this(amount, INIT_COUNT);
    }

    private LottoAmount(int amount, int manualLottoCount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입하려면 최소 1000원이 필요합니다.");
        }
        this.amount = amount;
        this.manualLottoCount = manualLottoCount;
    }

    public static final LottoAmount of(int amount) {
        return new LottoAmount(amount);
    }

    public static final LottoAmount ofManual(int amount, int manualLottoCount) {
        return new LottoAmount(amount, manualLottoCount);
    }

    public LottoAmount decrease() {
        return new LottoAmount(amount - LOTTO_PRICE, manualLottoCount);
    }

    public int getAutoLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public boolean isEndAutoLotto() {
        return (amount / LOTTO_PRICE) - manualLottoCount == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAmount that = (LottoAmount) o;
        return amount == that.amount &&
                manualLottoCount == that.manualLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, manualLottoCount);
    }
}
