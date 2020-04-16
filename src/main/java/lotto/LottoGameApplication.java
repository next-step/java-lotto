package lotto;

import lotto.domain.LottoSeller;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        System.out.println(money);

        int buyCount = money / 1000;
        ResultView.printBuyCount(buyCount);

        List<Object> lottos = LottoSeller.buy(buyCount);
        ResultView.printLottos(lottos);

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        // TODO: strings to lotto number
        List<Object> results = LottoSeller.match(lottos, winningLottoNumbers);
        ResultView.printResults(results);
    }

}
