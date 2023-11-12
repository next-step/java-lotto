package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final List<Lotto> lottos;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy,
                        BuyingAmount buyingAmount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < buyingAmount.units(); i++) {
            List<LottoNumber> numbers = lottoNumberStrategy.create();
            list.add(new Lotto(numbers));
        }
        this.lottos = List.copyOf(list);
    }

    public LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottoNumbers() {
        return this.lottos;
    }

    public WinningResults report(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = winningLotto.winningRank(lottos);
        return new WinningResults(lottoRanks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
