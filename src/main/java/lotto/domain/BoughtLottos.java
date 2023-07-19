package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoughtLottos {

    private final List<Lotto> lottos;

    public BoughtLottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public LottoResults winningResults(final WinningLotto winningLotto) {
        return new LottoResults(lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList()));
    }

    public static BoughtLottos merge(final BoughtLottos b1, final BoughtLottos b2) {
        final BoughtLottos merged = new BoughtLottos(b1.lottos);

        merged.lottos.addAll(b2.lottos);

        return merged;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
