package lotto.domain.service;

import lotto.domain.repository.Lottos;
import lotto.domain.repository.Numbers;
import lotto.domain.repository.WinningRank;

import java.util.List;
import java.util.stream.Collectors;

public class WinningChecker {
    private List<WinningRank> winningRanks;

    public WinningChecker(Lottos lottos, Numbers winningNumbers) {
        winningRanks = lottos.getSameNumberList(winningNumbers).stream()
                .map(WinningRank::getWinningRank)
                .collect(Collectors.toList());
    }

    public List<WinningRank> getWinningRanks() {
        return winningRanks;
    }
}
