package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public int getMoney() {
        return InputView.getMoney();
    }

    public int getLottoNum(int money) {
        int lottoNum = MoneyLottoMapper.calculateLottoNum(money);
        OutputView.showLottoNum(lottoNum);
        return lottoNum;
    }

    public WinningRankStatistics analyze(LotteryMachine lotteryMachine, Lottos lottos) {
        WinningRanks winningRanks = lotteryMachine.checkLottos(lottos);

        return new WinningRankStatistics(winningRanks);
    }

    public Lottos createLottos(int lottoNum) {
        Lottos lottos = new Lottos(lottoNum, new NumberSelectionStrategyImpl());
        OutputView.showLottos(lottos);
        return lottos;
    }

    public void showResult(WinningRankStatistics winningRankStatistics) {
        OutputView.showWinningRanks(winningRankStatistics);
        OutputView.showYield(winningRankStatistics.getYield());
    }

    public LotteryMachine getWinningNumbers() {
        Numbers winningNumbers = InputView.getWinningNumbers();
        return new LotteryMachine(winningNumbers);
    }
}
