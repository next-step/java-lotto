package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> determineRank(final LottoWinningNumber lottoWinningNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(lottoWinningNumber))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
