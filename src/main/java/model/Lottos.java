package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> determineRank(final WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningNumbers))
                .collect(Collectors.toList());
    }

    public List<Rank> determineRank(final LottoResult lottoResult) {
        return lottos.stream()
                .map(lotto -> lotto.match(lottoResult))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
