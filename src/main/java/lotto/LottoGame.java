package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static void runLottoGame() {
        int priceOfLotto = Utils.toInt( InputView.priceOfPurchase());
        BuyLottos buyLottos = new BuyLottos(priceOfLotto);
        buyLottos.buyLottos();  // 로또 생성.

        OutputView.printBuyLotto(buyLottos); // 생성 로또 보여주기

        Lotto winLotto = new Lotto(Utils.toList(InputView.numberOfWinLotto()));

        LottoMatch lottoMatch = new LottoMatch();
        lottoMatch.checkRank(buyLottos,winLotto);

        OutputView.printLottoResult();
        OutputView.printRank(lottoMatch.getRankOfLotto());
        OutputView.printCalProfit(lottoMatch.getRankOfLotto(), priceOfLotto);

    }

}
