package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.service.NumberSelectionStrategyImpl;
import lotto.service.WinningRankStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static Lottos getManualLottosNumbers(int autoLottoCount) {
        return new Lottos(InputView.getManualLottosNumbers(autoLottoCount).stream()
                .map(LottoController::getLotto)
                .collect(Collectors.toList()));
    }

    private static Lotto getLotto(List<Integer> lottosNumbers) {
        Numbers.Builder builder = Numbers.builder();
        lottosNumbers.stream().map(builder::add);
        return new Lotto(builder.build());
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
