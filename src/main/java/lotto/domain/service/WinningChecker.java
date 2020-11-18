package lotto.domain.service;

import lotto.domain.repository.Lottos;
import lotto.domain.repository.Numbers;
import lotto.domain.repository.WinningRank;
import lotto.domain.repository.WinningRanks;

import java.util.List;
import java.util.stream.Collectors;

public class WinningChecker {

    private WinningChecker() {
    }

    public static WinningRanks checkWinningRanks(Lottos lottos, Numbers winningNumbers) {
        List<WinningRank> winningRankList = lottos.getSameNumberList(winningNumbers).stream()
                .map(WinningRank::getWinningRank)
                .collect(Collectors.toList());

        return new WinningRanks(winningRankList);
    }
}
