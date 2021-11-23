package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.readMoney();

        LottoShop shop = new LottoShop();
        List<Lotto> lottos = shop.buyLottos(money);
        ResultView.printLottos(lottos);

        String winningNumber = InputView.readWinningNumber();

        LottoResult result = shop.match(lottos, new Lotto(winningNumber));
        ResultView.printResult(result);
    }

}
