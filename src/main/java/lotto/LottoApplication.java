package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoShop;
import lotto.strategy.MakeAutoLottoNumber;
import lotto.strategy.MakeLottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args){
        LottoShop lottoShop = new LottoShop(InputView.requestPurchaseAmount());

        ResultView.responseLottoCount(lottoShop.getBuyRound());

        MakeLottoNumber makeLottoNumber = new MakeAutoLottoNumber();
        LottoGame lottoGame = new LottoGame(lottoShop.getBuyRound(), makeLottoNumber);
        ResultView.responseLottoNumbers(lottoGame.getLottos());

        String winningNumber = InputView.requestLastWeekWinningNumber();
        ResultView.responseWinningStatistics(lottoGame.getResultStatics(winningNumber, lottoShop.getBuyRound()));
    }
}
