package lotto.domain;

import java.util.Objects;

public class LottoStore {
    public static final int ZERO = 0;
    public static final int LOTTO_PRICE = 1_000;

    private final Money money;
    private final LottoCount lottoCount;

    public LottoStore(Money money, LottoCount lottoCount) {
        this.money = money;
        this.lottoCount = lottoCount;
    }

    public static LottoStore of(Money money, LottoCount lottoCount) {
        return new LottoStore(money, lottoCount);
    }

    public Lottos issueLotto(ManualLottoGenerator manualLottoGenerator) {
        return manualLottoGenerator.generate()
                .concat(new AutoLottoGenerator(lottoCount.calculateCount(money.getPrice())).generate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStore that = (LottoStore) o;
        return Objects.equals(money, that.money) &&
                Objects.equals(lottoCount, that.lottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottoCount);
    }
}
