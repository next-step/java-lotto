package lotto.view.resultview;

import lotto.domain.Lottos;
import lotto.domain.ManualLottoNumbers;
import lotto.dto.WinningStatistic;

public interface ResultView {
    void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, Lottos boughtLottos);

    void printWinningStatistic(WinningStatistic winningStatistic);
}
