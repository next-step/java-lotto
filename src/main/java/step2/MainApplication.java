package step2;


import step2.domain.LottoGame;
import step2.view.InputView;
import step2.view.OutputView;


/*
 * LOTTO GAME
 * MainApplication
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class MainApplication {


    public static void main(String[] args) {

        // input to buy
        String payMoney = InputView.inputPayMoney();

        // check buy Lotto
        int gameCount = LottoGame.buyLotto(payMoney);

        // lottoList = LottoGame.
        LottoGame.issueLotto(gameCount);

        //OutputView.
        OutputView.outputLottoList(LottoGame.getLottoList());

        // get Wining Number
        String winingNumber = InputView.inputWiningNumber();

        LottoGame.checkWiningNumber(winingNumber);

        // prize Rules!!
        LottoGame.makeRules();

        // matching numbers
        LottoGame.matchingWinningNumbers();
        OutputView.outputPrizeList(LottoGame.getPrizeList());

        // calc ratio of win.
        OutputView.outputWinningResult(LottoGame.totalResult());

    }

}
