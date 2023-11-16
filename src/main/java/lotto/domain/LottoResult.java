package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final WinningLotto winningLotto;

    public LottoResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Long> findWinningRankCont(List<Lotto> lottos) {
        return findWinningRanks(lottos).stream()
                .filter(Rank::isWinningRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private List<Rank> findWinningRanks(List<Lotto> lottos) {
        return lottos.stream()
                .map(userLotto -> {
                    int matchCount = this.winningLotto.match(userLotto);
                    boolean isBonusWinning = this.winningLotto.isBonusWinning(userLotto);
                    return Rank.findRank(matchCount, isBonusWinning);
                })
                .collect(Collectors.toList());
    }
}
