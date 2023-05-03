package lotto;

import lotto.domain.*;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        ResultView.printCostOfLotto();
        int cost = InputView.inputCostOfLotto();

        LottoMachine lottoMachine = new LottoMachine(cost);
        ResultView.printNumbersOfLotto(lottoMachine.getNumberOfLotto());

        Lottos lottos = lottoMachine.create(new LottoCreatingRandomStrategy());
        ResultView.printLottos(lottos);

        ResultView.printWinningNumber();
        String winningNumbers = InputView.inputWinningNumber();

        LottoResult result = new LottoResult(lottos);
        LottoStatics statics = new LottoStatics(cost, result.checkWinningNumbers(winningNumbers), new LottoRewardStartAt3Strategy());

        ResultView.printStatistics(statics.getStatics(), statics.getReward());
        ResultView.printLottoRate(statics.getRate());
    }
}
