package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int money = inputView.askPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(money);

        ResultView resultView = new ResultView();
        resultView.printLotties(lottoMachine);

        String winningNumber = inputView.getWinningNumber();
        lottoMachine.confirmLotto(winningNumber);

        resultView.printSameNumbers();
    }
}
