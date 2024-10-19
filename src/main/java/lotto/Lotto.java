package lotto;

import random.LottoGenerator;

import java.util.Objects;

public class Lotto {
    TryLottoCount tryLottoCount;

    public Lotto(TryLottoCount tryLottoCount) {
        this.tryLottoCount = tryLottoCount;
    }

    public static Lotto InitLotto(int purchaseAmount) {
        return new Lotto(new TryLottoCount(Math.floorDiv(purchaseAmount, 1000)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(tryLottoCount, lotto.tryLottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryLottoCount);
    }
}
