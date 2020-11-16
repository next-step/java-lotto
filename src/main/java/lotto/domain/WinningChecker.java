package lotto.domain;

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
