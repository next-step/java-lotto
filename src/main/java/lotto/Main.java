package lotto;

import lotto.domain.LottoCreatingRandomStrategy;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
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
        result.checkWinningNumbers(winningNumbers);
    }
}
