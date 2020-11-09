package lotto.view.resultview;

import lotto.domain.Lotto;
import lotto.dto.WinningStatistic;

import java.util.List;

public interface ResultView {
    void printBoughtLottos(List<Lotto> boughtLottos);

    void printWinningStatistic(WinningStatistic winningStatistic);
}
