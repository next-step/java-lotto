package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final List<Lotto> lottos;
    private final List<Lotto> manaulLottos;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy,
                        BuyingAmount buyingAmount,
                        List<Lotto> manaulLottos) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < buyingAmount.units() - manaulLottos.size(); i++) {
            List<LottoNumber> numbers = lottoNumberStrategy.create();
            list.add(new Lotto(numbers));
        }
        this.lottos = List.copyOf(list);
        this.manaulLottos = List.copyOf(manaulLottos);
    }

    public LottoMachine(List<Lotto> lottos,
                        List<Lotto> manaulLottos) {
        this.lottos = lottos;
        this.manaulLottos = manaulLottos;
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public int manualLottoCount() {
        return this.manaulLottos.size();
    }

    public List<Lotto> getLottoNumbers() {
        return this.lottos;
    }

    public List<Lotto> getManualLottoNumbers() {
        return this.manaulLottos;
    }

    public WinningResults report(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = winningLotto.winningRank(lottos);
        lottoRanks.addAll(winningLotto.winningRank(manaulLottos));
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
