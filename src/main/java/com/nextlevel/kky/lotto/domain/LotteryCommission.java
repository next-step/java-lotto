package com.nextlevel.kky.lotto.domain;

import com.nextlevel.kky.lotto.model.Lotto;
import com.nextlevel.kky.lotto.model.WinningStatistics;

import java.util.List;
import java.util.stream.Stream;

public class LotteryCommission {

    public static WinningStatistics calculateWinningStatistics(Lotto winningNumbers, List<Lotto> lottoList) {
        WinningStatistics winningStatistics = new WinningStatistics();
        for (Lotto lotto : lottoList) {
            int matchCount = getMatchCount(winningNumbers, lotto);
            int originalCount = winningStatistics.getWinningMap().get(matchCount);
            winningStatistics.getWinningMap().replace(matchCount, ++originalCount);
        }
        return winningStatistics;
    }

    private static int getMatchCount(Lotto winningNumbers, Lotto lotto) {
        Stream<Integer> matchStream = lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().contains(number));

        return (int) matchStream.count();
    }
}
