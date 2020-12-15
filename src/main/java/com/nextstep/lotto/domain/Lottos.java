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
            winnings.add(lotto.match(winningLotto));
        }
        return new LottoStatistics(winnings);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
