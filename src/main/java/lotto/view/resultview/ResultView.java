package lotto.view.resultview;

import lotto.domain.Lotto;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.WinningStatistic;

import java.util.List;

public interface ResultView {
    void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, List<Lotto> boughtLottos);

    void printWinningStatistic(WinningStatistic winningStatistic);
}
