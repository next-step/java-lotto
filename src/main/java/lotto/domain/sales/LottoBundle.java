package lotto.domain.sales;

import lotto.domain.number.Lotto;
import lotto.domain.prize.WinningPrize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoBundle of(int quantity, List<String> manuals) {
        List<Lotto> lottos = new ArrayList<>();
        manuals.forEach(manual -> lottos.add(new Lotto(manual)));

        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.create());
        }
        return new LottoBundle(lottos);
    }

    public WinningPrize winningPrize(WinningLotto winningLotto) {
        WinningPrize winningPrize = new WinningPrize();
        for (Lotto lotto : lottos) {
            winningPrize.record(winningLotto.lottoPrize(lotto));
        }
        return winningPrize;
    }

    public Collection<Lotto> lottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
