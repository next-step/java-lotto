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

    public void addAll(List<Lotto> otherLottos) {
        lottos.addAll(otherLottos);
    }

    public LottoStatistics getStatistics(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("winning numbers are not allowed empty value");
        }
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
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
