package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

public class LottoGameController {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.requestMoney());
        LottoNumbers boughtNumbers = lottoGame.buy();
        LottoGameResults lottoGameResults = lottoGame.checkResult(boughtNumbers, InputView.requestWinningNumber());
    }
}
