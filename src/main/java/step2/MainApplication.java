package step2;


import step2.domain.LottoGame;
import step2.domain.Money;
import step2.view.InputView;
import step2.view.OutputView;


/*
 * LOTTO GAME
 * MainApplication
 * ver. 1.0
 * 2020.05.31

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
        OutputView.outputLottoList(lottoGame.getLottoList());

        // get Wining Number
        String winingNumber = InputView.inputWiningNumber();

        lottoGame.checkWiningNumber(winingNumber);

        // prize Rules!!
        lottoGame.makeRules();

        // matching numbers
        lottoGame.matchingWinningNumbers();
        OutputView.outputPrizeList(lottoGame.getPrizeList());

        // calc ratio of win.
        OutputView.outputWinningResult(lottoGame.totalResult());

    }

}
