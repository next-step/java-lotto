package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.service.NumberSelectionStrategyImpl;
import lotto.service.WinningRankStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static Lottos getManualLottosNumbers(int autoLottoCount) {
        return InputView.getAutoLottos(autoLottoCount);
    }

    public static Lottos createLottos(int lottoNum) {
        Lottos lottos = new Lottos(lottoNum, new NumberSelectionStrategyImpl());
        OutputView.showLottos(lottos);
        return lottos;
    }

    public int getMoney() {
        return InputView.getMoney();
    }

    public void showResult(WinningRankStatistics winningRankStatistics) {
        OutputView.showWinningRanks(winningRankStatistics);
        OutputView.showYield(winningRankStatistics.calculateYield());
    }

    public Numbers getWinningNumbers() {
        Numbers.Builder builder = new Numbers.Builder();

        InputView.getWinningNumbers().forEach(builder::add);
        return builder.build();
    }

    public Number getBonusNumber() {
        return new Number(InputView.getBonusNumber());
    }

    public int getManualLottoNumber() {
        return InputView.getAutoLottoCount();
    }
}
