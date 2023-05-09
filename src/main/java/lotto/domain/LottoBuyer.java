package lotto.domain;


import java.util.Objects;

public class LottoBuyer {
    private Lottos lottos;
    private final Store store;

    public LottoBuyer(Store lottoStore) {
        this.store = lottoStore;
    }

    public Lottos buyLottos(Money buyAmount) {
        this.lottos = store.sell(buyAmount);
        return lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer that = (LottoBuyer) o;
        return Objects.equals(lottos, that.lottos) && Objects.equals(store, that.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, store);
    }

    public RankResult checkWinning(Lotto winningLotto, LottoNumber bonus) {
        return new RankResult(lottos.countMatching(winningLotto, bonus));
    }
}
