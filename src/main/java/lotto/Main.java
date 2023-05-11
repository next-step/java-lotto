package lotto;

import lotto.domain.*;

import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import javax.xml.transform.Result;
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
        ResultView.printNumbersOfLotto(lottoMachine.getNumberOfManualLottos(), lottoMachine.getNumberOfAutoLottos());

        Lottos manualLottos = lottoMachine.generateManualLotto(manualLottosNumber);
        Lottos autoLottos = lottoMachine.generateAutoLotto();
        ResultView.printLottos(manualLottos);
        ResultView.printLottos(autoLottos);

        ResultView.printWinningNumber();
        String winningNumbers = InputView.inputWinningNumber();

        ResultView.printBonusBall();
        int bonusBallNumber = InputView.inputBonusBallNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBallNumber);

        LottoStatics statics = new LottoStatics(cost, winningLotto.checkWinningNumbers(autoLottos));

        ResultView.printStatistics(statics.getStatistics(), Rank.getWinningCounts());
        ResultView.printLottoRate(statics.getRate());
    }
}
