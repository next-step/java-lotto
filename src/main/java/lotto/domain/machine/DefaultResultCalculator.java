package lotto.domain.machine;

import lotto.domain.LottoPaper;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStatistics;

import java.util.function.Function;
import java.util.stream.Collectors;

public class DefaultResultCalculator implements ResultCalculator {
    @Override
    public WinningStatistics calculate(final LottoPaper lottoPaper, final WinningNumber winningNumber) {
        return new WinningStatistics(
                lottoPaper.viewResults(winningNumber)
                        .stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }
}
