package step3;


import step3.domain.LottoGame;
import step3.domain.Money;
import step3.view.view.InputView;
import step3.view.view.OutputView;

/*
 * LOTTO GAME
 * MainApplication
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class MainApplication {


    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame();

        // input to buy
        Money payedmoney = new Money(InputView.inputPayMoney());


        // check buy Lotto
        int gameCount = lottoGame.calculateGameCountByPayMoney(payedmoney);

        // lottoList = LottoGame.
        lottoGame.issueLotto(gameCount);

        //OutputView.
        OutputView.outputLottoList(lottoGame.getLottoTickets());

        // get Wining Number
        String winingNumber = InputView.inputWiningNumber();
        String bonusNumber = InputView.inputBonusNumber();

        lottoGame.checkWiningNumber(winingNumber, bonusNumber);

        // matching numbers
        lottoGame.matchingWinningNumbers();
        OutputView.outputPrizeList(lottoGame.getPrizeList());

        // calc ratio of win.
        OutputView.outputWinningResult(lottoGame.totalResult());

    }

}
