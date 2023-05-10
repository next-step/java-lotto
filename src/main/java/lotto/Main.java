package lotto;

import lotto.domain.*;

import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResultView.printCostOfLotto();
        int cost = InputView.inputCostOfLotto();

        ResultView.printNumberOfManualLotto();
        int numberOfManualLottos = InputView.inputNumberOfManualLottos();

        ResultView.printManualLottosNumber();
        List<String> manualLottosNumber = InputView.inputManualLottos(numberOfManualLottos);

        LottoMachine lottoMachine = new LottoMachine(cost);
        ResultView.printNumbersOfLotto(numberOfManualLottos, lottoMachine.getNumberOfLotto());

        Lottos lottos = lottoMachine.create();
        ResultView.printLottos(lottos);

        ResultView.printWinningNumber();
        String winningNumbers = InputView.inputWinningNumber();

        ResultView.printBonusBall();
        int bonusBallNumber = InputView.inputBonusBallNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBallNumber);

        LottoStatics statics = new LottoStatics(cost, winningLotto.checkWinningNumbers(lottos));

        ResultView.printStatistics(statics.getStatistics(), Rank.getWinningCounts());
        ResultView.printLottoRate(statics.getRate());
    }
}
