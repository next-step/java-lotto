package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long size() {
        return lottos.size();
    }

    public LottoResults matchWinningLotto(WinningLotto winningLotto) {
        return new LottoResults(
                lottos.stream()
                        .map(winningLotto::match)
                        .collect(Collectors.toList())
        );
    }
}
