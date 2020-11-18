package lotto.controller;

import lotto.domain.repository.Lottos;
import lotto.domain.repository.Numbers;
import lotto.domain.repository.WinningRanks;
import lotto.domain.service.LotteryMachine;
import lotto.domain.service.NumberSelectionStrategyImpl;
import lotto.domain.service.WinningRankStatistics;
import lotto.domain.util.MoneyLottoMapper;
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
        OutputView.showYield(winningRankStatistics.calculateYield());
    }

    public LotteryMachine getWinningNumbers() {
        Numbers.Builder builder = new Numbers.Builder();

        InputView.getWinningNumbers().forEach(builder::add);
        Numbers winningNumbers = builder.build();

        return new LotteryMachine(winningNumbers);
    }
}
