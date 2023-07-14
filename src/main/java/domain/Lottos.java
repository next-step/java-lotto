package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> checkAllLottoResult(final WinningLotto winningLotto) {
        return lottos.stream()
            .map(winningLotto::resolveRank)
            .collect(Collectors.toList());
    }
}
