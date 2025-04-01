package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        List<Rank> rankList = lottos.stream()
                .map(lotto -> lotto.getRank(winningLotto))
                .collect(Collectors.toList());
        return new LottoResult(rankList);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
