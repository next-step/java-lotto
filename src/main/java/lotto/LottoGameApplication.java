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
        LottoNumber bonusNumber = LottoNumber.of(inputBonusLottoNumber);
        Lotto winningLotto = Lotto.ofComma(winningLottoNumbers);

        MatchResult result = LottoSeller.match(lottos, winningLotto, bonusNumber);
        ResultView.printResults(result, money);
    }

}
