package lotto;

import lotto.services.LottoShop;
import lotto.domains.Lottos;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            String money = InputView.money();
            Lottos lottos = new Lottos(money);

            ResultView.printLottoCount(lottos.numOfLotto());
            ResultView.printLottos(lottos);

            String lastWeekWinningNumberString = InputView.lastWeekWinnerNumbers();
            LottoShop lottoShop = new LottoShop(lastWeekWinningNumberString);

            ResultView.printLottoResult(lottoShop.winner(lottos));
            ResultView.printProfitRate(lottoShop.profitRate(money));

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
