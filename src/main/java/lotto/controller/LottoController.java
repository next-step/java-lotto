package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Numbers;
import lotto.domain.WinningRanks;
import lotto.service.LotteryMachine;
import lotto.service.NumberSelectionStrategyImpl;
import lotto.service.WinningRankStatistics;
import lotto.util.MoneyLottoMapper;
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

    public WinningRankStatistics analyze(Lottos lottos, Numbers winningNumbers) {
        LotteryMachine lotteryMachine = new LotteryMachine(lottos, winningNumbers);
        WinningRanks winningRanks = lotteryMachine.getWinningRanks();
        return new WinningRankStatistics(winningRanks);
    }

    public Lottos createLottos(int lottoNum) {
        Lottos lottos = new Lottos(lottoNum, new NumberSelectionStrategyImpl());
        OutputView.showLottos(lottos);
        return lottos;
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
}
