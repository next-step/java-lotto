package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.Match;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Map;

public class LottoGameApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        Lottos lottos = LottoSeller.buy(money);
        ResultView.buyResult(lottos);

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        Lotto winningLotto = Lotto.ofComma(winningLottoNumbers);
        Map<Match, Integer> result = LottoSeller.match(lottos, winningLotto);
        ResultView.printResults(result, money);
    }

}
