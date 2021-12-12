package lotto;

import lotto.domain.*;
import lotto.strategy.CreationAutoLottoNumber;
import lotto.strategy.CreationLottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(InputView.requestPurchaseAmount());

        ResultView.responseLottoCount(lottoShop.getBuyRound());

        CreationLottoNumber makeLottoNumber = new CreationAutoLottoNumber();
        Lottos lottos = Lottos.of(lottoShop.getBuyRound(), makeLottoNumber);
        ResultView.responseLottoNumbers(lottos);

        PrizeLotto prizeLotto = new PrizeLotto(InputView.requestLastWeekWinningNumber(), InputView.requestBonusNumber());
        Calculator calculator = new Calculator(lottos.getResults(prizeLotto), lottoShop.getBuyAmount());
        ResultView.responseStatistics(calculator);
    }
}
