package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import lotto.domain.WinningRanks;

import java.util.stream.Collectors;

public class WinningChecker {

    private WinningLotto winningLotto;

    public WinningChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningRanks checkRanks(Lottos lottos) {
        return new WinningRanks(lottos.getRankMatchers(winningLotto).stream()
                .map(WinningRank::getWinningRank)
                .collect(Collectors.toList()));
    }
}
