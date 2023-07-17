package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<Rank> checkAllLottoResult(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::resolveRank)
                .collect(Collectors.toList());
    }

    public Lottos merge(final Lottos autoLottos) {
        List<Lotto> merged = new ArrayList<>();
        merged.addAll(this.lottos);
        merged.addAll(autoLottos.lottos);

        return new Lottos(merged);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
