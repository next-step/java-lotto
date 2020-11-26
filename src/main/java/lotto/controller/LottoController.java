package lotto.controller;

import lotto.domain.Number;
import lotto.domain.*;
import lotto.service.WinningChecker;
import lotto.service.WinningRankStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static LottoCounter createLottoCounter() {
        int money = InputView.getMoney();
        int manualLottoNumber = InputView.getManualLottoCount();
        return new LottoCounter(money, manualLottoNumber);
    }

    public static WinningLotto createWinningLotto() {
        Numbers winningNumbers = getWinningNumbers();
        Number bonus = getBonusNumber();
        return new WinningLotto(winningNumbers, bonus);
    }

    public static Lottos getManualLottos(int autoLottoCount) {
        return new Lottos(InputView.getManualLottosNumbers(autoLottoCount).stream()
                .map(LottoController::getLotto)
                .collect(Collectors.toList()));
    }

    public static void showLottosWithCount(Lottos lottos, LottoCounter lottoCounter) {
        OutputView.showLottoCount(lottoCounter.getManualLottoCount(), lottoCounter.getAutoLottoCount());
        OutputView.showLottos(lottos);
    }

    public static WinningRankStatistics getWinningRankStatistics(Lottos lottos, WinningLotto winningLotto) {
        WinningChecker winningChecker = new WinningChecker(winningLotto);
        WinningRanks winningRanks = winningChecker.getWinningRanks(lottos);
        return new WinningRankStatistics(winningRanks);
    }

    private static Lotto getLotto(List<Integer> lottosNumbers) {
        Numbers.Builder builder = Numbers.builder();
        lottosNumbers.forEach(builder::add);
        return new Lotto(builder.build());
    }

    public static void showResult(WinningRankStatistics winningRankStatistics) {
        OutputView.showWinningRanks(winningRankStatistics);
        OutputView.showYield(winningRankStatistics.calculateYield());
    }

    public static Numbers getWinningNumbers() {
        Numbers.Builder builder = new Numbers.Builder();

        InputView.getWinningNumbers().forEach(builder::add);
        return builder.build();
    }

    public static Number getBonusNumber() {
        return new Number(InputView.getBonusNumber());
    }
}
