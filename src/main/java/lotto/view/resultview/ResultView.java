package lotto.view.resultview;

import lotto.Lotto;
import lotto.WinningStatistic;

import java.util.List;

public interface ResultView {
    void printBoughtLottos(List<Lotto> boughtLottos);

    void printWinningStatistic(WinningStatistic winningStatistic);
}
