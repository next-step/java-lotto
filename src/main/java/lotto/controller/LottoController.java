package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.wrapper.Numbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private LottoGame lottoGame;
    private InputView inputView;
    private ResultView resultView;

    public LottoController() {
        lottoGame = new LottoGame();
        inputView = new InputView();
        resultView = new ResultView(lottoGame);
    }

    public void startGame() {
        int numOfLotto;
        while (true) {
            try {
                numOfLotto = inputView.inputPurchaseMoney();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        resultView.printPurchaseResult(numOfLotto);

        Numbers winningNumbers;
        while (true) {
            try {
                winningNumbers = inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        resultView.printLottoGameResult(winningNumbers);
    }
}
