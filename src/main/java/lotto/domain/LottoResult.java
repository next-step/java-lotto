package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoResult(WinningLotto winningLotto, Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
    }

    public Map<Rank, Long> findWinningRanks() {
        return Collections.unmodifiableMap(
                this.lottos.getLottos()
                        .stream()
                        .map(this.winningLotto::match)
                        .map(Rank::findRank)
                        .filter(Rank::isWinningRank)
                        .collect(Collectors.groupingBy(rank -> rank, Collectors.counting())));
    }
}
