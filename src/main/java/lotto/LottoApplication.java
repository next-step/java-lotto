package lotto;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.strategy.CreationAutoLottoNumber;
import lotto.strategy.CreationLottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(InputView.requestPurchaseAmount());

        ResultView.responseLottoCount(lottoShop.getBuyRound());

        CreationLottoNumber makeLottoNumber = new CreationAutoLottoNumber();
        Lottos lottos = new Lottos(lottoShop.getBuyRound(), makeLottoNumber);
        ResultView.responseLottoNumbers(lottos);

        Lotto winningLotto = new Lotto(InputView.requestLastWeekWinningNumber());
        Calculator calculator = new Calculator(lottos.getResult(winningLotto), lottoShop.getBuyAmount());
        ResultView.responseStatistics(calculator);
    }
}
