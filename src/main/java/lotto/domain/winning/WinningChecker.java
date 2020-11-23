package lotto.domain.winning;

import lotto.domain.Lottos;
import lotto.domain.game.Lotto;

import java.util.List;

/**
 * Created By mand2 on 2020-11-19.
 * 당첨번호와 내 로또번호가 얼마나 맞는지 확인.
 */
public class WinningChecker {

    private final List<Integer> winningNumbers;
    private static final WinningStatistics winningStatistics = new WinningStatistics();

    private WinningChecker(WinningNumber winningNumber) {
        this.winningNumbers = winningNumber.value();
    }

    public static WinningChecker of(WinningNumber winningNumber) {
        return new WinningChecker(winningNumber);
    }

    public WinningStatistics winningStatistics(Lottos lottos) {
        for (Lotto lotto : lottos.list()) {
            winningStatistics.add(getWinningResult(lotto));
        }
        return winningStatistics;
    }

    private WinningRank getWinningResult(Lotto lotto) {
        long matchedNumber = compare(lotto);
        return WinningRank.getWinningRank((int) matchedNumber);
    }

    private long compare(Lotto lotto) {
        return lotto.number().stream()
                .filter(num -> this.winningNumbers.contains(num))
                .count();
    }

}
