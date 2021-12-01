package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    
    public static void main(String[] args){
        int purchaseAmount= InputView.requestPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);
        ResultView.responseLottoCount(lottoGame.getBuyRound());

//        Lottos lottos = lotto.start();
//        ResultView.responseLottoNumbers(lottos.getLottos());

//        WinningNumber winningNumber = new WinningNumber(InputView.requestLastWeekWinningNumber());
//        ResultView.responseWinningStatistics(winningNumber);
//        ResultView.responseWinningRate(winningNumber, purchaseAmount);
    }
}
