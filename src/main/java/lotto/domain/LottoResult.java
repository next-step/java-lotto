package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoResult(WinningLotto winningLotto, Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
    }

    public Map<Rank, Long> findWinningRankCont() {
        return findWinningRanks().stream()
                .filter(Rank::isWinningRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private List<Rank> findWinningRanks() {
        return this.lottos.getTotalLottos().stream()
                .map(userLotto -> {
                    int matchCount = this.winningLotto.match(userLotto);
                    boolean isBonusWinning = this.winningLotto.isBonusWinning(userLotto);
                    return Rank.findRank(matchCount, isBonusWinning);
                })
                .collect(Collectors.toList());
    }
}
