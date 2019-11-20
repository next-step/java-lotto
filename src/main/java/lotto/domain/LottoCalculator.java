package lotto.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:19
 */
public class LottoCalculator {

    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;
    private final int amount;
    private final int manualLottoCount;

    private LottoCalculator(int amount) {
        this(amount, INIT_COUNT);
    }

    private LottoCalculator(int amount, int manualLottoCount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입하려면 최소 1000원이 필요합니다.");
        }
        this.amount = amount;
        this.manualLottoCount = manualLottoCount;
    }

    public static final LottoCalculator of(int amount) {
        return new LottoCalculator(amount);
    }

    public static final LottoCalculator ofManual(int amount, int manualLottoCount) {
        return new LottoCalculator(amount, manualLottoCount);
    }

    public LottoCalculator decrease() {
        return new LottoCalculator(amount - LOTTO_PRICE, manualLottoCount);
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
        LottoCalculator that = (LottoCalculator) o;
        return amount == that.amount &&
                manualLottoCount == that.manualLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, manualLottoCount);
    }
}
