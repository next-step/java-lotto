package step3;

import step3.domain.LottoGame;
import step3.domain.Money;
import step3.domain.WinningLotto;
import step3.view.view.InputView;
import step3.view.view.OutputView;

/*
 * LOTTO GAME
 * MainApplication
 * ver. 1.0
 * 2020.05.31
 */
public class MainApplication {

    public static void main(String[] args) {
        // input to buy
        Money payedmoney = new Money(InputView.inputPayMoney());
        LottoGame lottoGame = new LottoGame(payedmoney);

        //OutputView.
        OutputView.outputLottoList(lottoGame.getLottoTickets());

        // get Wining Number
        String winingNumber = InputView.inputWiningNumber();
        String bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = WinningLotto.of(winingNumber, bonusNumber);

        // matching numbers
        lottoGame.matchingWinningNumbers(winningLotto);
        OutputView.outputPrizeList();

        // calc ratio of win.
        OutputView.outputWinningResult(lottoGame.totalResult());
    }

}


