package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args){
        LottoGame lottoGame = new LottoGame(InputView.requestPurchaseAmount());
        ResultView.responseLottoCount(lottoGame.getBuyRound());

        ResultView.responseLottoNumbers(lottoGame.getLottos());

        ResultView.responseWinningStatistics(lottoGame.getResultStatics(InputView.requestLastWeekWinningNumber()));
    }
}
