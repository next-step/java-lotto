package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGameApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        Lottos lottos = LottoSeller.buy(money);
        ResultView.buyResult(lottos);

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        int inputBonusLottoNumber = InputView.inputBonusLottoNumber();
        WinningLotto winningLotto = WinningLotto.of(Lotto.ofComma(winningLottoNumbers), inputBonusLottoNumber);

        MatchResult result = LottoSeller.match(lottos, winningLotto);
        ResultView.printResults(result, money);
    }

}
