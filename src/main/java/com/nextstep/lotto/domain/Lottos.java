package com.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public LottoStatistics summarizingLotto(WinningLotto winningLotto) {
        List<LottoRank> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            winnings.add(match(winningLotto, lotto));
        }
        return new LottoStatistics(winnings);
    }

    private LottoRank match(WinningLotto winningLotto, Lotto collectedLotto) {
        long matchedCount = winningLotto.matchedCount(collectedLotto);
        boolean matchedBonus = winningLotto.checkBonusNumber(collectedLotto);
        return LottoRank.select(matchedCount, matchedBonus);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
