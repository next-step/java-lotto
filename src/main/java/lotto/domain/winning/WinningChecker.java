package lotto.domain.winning;

import lotto.domain.Lottos;
import lotto.domain.game.Lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created By mand2 on 2020-11-19.
 * 당첨번호와 내 로또번호가 얼마나 맞는지 확인.
 */
public class WinningChecker {

    private final WinningNumber winningNumber;

    private WinningChecker(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningChecker of(WinningNumber winningNumber) {
        return new WinningChecker(winningNumber);
    }

    public WinningStatistics winningStatistics(Lottos lottos) {
        Map <WinningRank, Long> countPerRank = lottos.list()
                .stream()
                .map(this::getWinningResult)
                .collect(Collectors.groupingBy(Function.identity(),
                                            Collectors.counting()))
                ;

        return WinningStatistics.from(countPerRank);
    }

    private WinningRank getWinningResult(Lotto lotto) {
        return winningNumber.match(lotto);
    }

}
