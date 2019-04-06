package lotto.domain.machine;

import lotto.domain.LottoPaper;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStatistics;

@FunctionalInterface
public interface ResultCalculator {
    WinningStatistics calculate(LottoPaper lottoPaper, WinningNumber winningNumber);
}
