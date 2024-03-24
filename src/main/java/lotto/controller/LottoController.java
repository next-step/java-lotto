package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringToInt;
import lotto.utils.StringToList;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {
        int priceOfLotto = StringToInt.toInt( InputView.priceOfPurchase());
        BuyLottos buyLottos = new BuyLottos(priceOfLotto);
        buyLottos.buyLottos();  // 로또 생성.

        OutputView.printBuyLotto(buyLottos); // 생성 로또 보여주기

        Lotto winLottoNum = new Lotto(StringToList.toList(InputView.numberOfWinLotto()));
        BonusNum bonusNum = new BonusNum(StringToInt.toInt(InputView.numberOfBonus()), winLottoNum);

        WinLotto winLottoAll = new WinLotto(winLottoNum, bonusNum);

        LottoMatch lottoMatch = new LottoMatch();
        lottoMatch.checkRank(buyLottos,winLottoAll);

        OutputView.printLottoResult();
        OutputView.printRank(lottoMatch.getRankOfLotto());
        OutputView.printCalProfit(lottoMatch.getRankOfLotto(), priceOfLotto);

    }

}
