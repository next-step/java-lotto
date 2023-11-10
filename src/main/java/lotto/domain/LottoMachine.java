package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> lottos;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy,
                        BuyingAmount buyingAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < buyingAmount.units(); i++) {
            List<Integer> numbers = lottoNumberStrategy.create();
            lottos.add(new Lotto(numbers));
        }
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottoNumbers() {
        return this.lottos;
    }

    public WinningResults report(WinningLotto winningLotto) {
        return new WinningResults(winningLotto, lottos);
    }
}
