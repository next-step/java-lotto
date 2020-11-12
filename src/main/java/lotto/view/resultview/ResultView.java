package lotto.view.resultview;

import lotto.domain.Lotto;
import lotto.dto.WinningStatistic;

import java.util.List;

public interface ResultView {
    void printBoughtLottos(int numberOfManualLotto, List<Lotto> boughtLottos);

    void printWinningStatistic(WinningStatistic winningStatistic);
}
