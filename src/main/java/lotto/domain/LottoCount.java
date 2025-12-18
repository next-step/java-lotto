package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private int count;


    public LottoCount(String count) {
        this(Integer.parseInt(count));
    }

    public LottoCount(String purchaseAmount, int pricePerLotto) {
        this(Integer.parseInt(purchaseAmount) / pricePerLotto);
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public boolean isBiggerOrSameThan(LottoCount other) {
        return this.count >= other.count;
    }

    public LottoCount increase() {
        return new LottoCount(this.count + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
