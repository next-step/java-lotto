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

        Lottos lottos = lottoMachine.create();
        ResultView.printLottos(lottos);

        ResultView.printWinningNumber();
        String winningNumbers = InputView.inputWinningNumber();
        ResultView.printBonusBall();
        int bonusBallNumber = InputView.inputBonusBallNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        LottoStatics statics = new LottoStatics(cost, winningLotto.checkWinningNumbers(lottos));

        ResultView.printStatistics(statics.getStatistics(), Rank.getCountList());
        ResultView.printLottoRate(statics.getRate());
    }
}
