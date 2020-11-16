package lotto.view.resultview;

import lotto.dto.Lottos;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.WinningStatistic;

public interface ResultView {
    void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, Lottos boughtLottos);

    void printWinningStatistic(WinningStatistic winningStatistic);
}
