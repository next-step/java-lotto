package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringToIntConverter;
import lotto.utils.StringToListConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private static final int ONE_LOTTO = 1000;

    public static void run() {
        int priceOfLotto = StringToIntConverter.toInt( InputView.priceOfPurchase());
        int LottoNum = priceOfLotto / ONE_LOTTO;
        int numOfManual = StringToIntConverter.toIntManual(LottoNum, InputView.numOfManual());

        BuyLottos buyLottos = genBuyLottos(priceOfLotto, numOfManual);
        OutputView.printNumOfAutoAndManual(LottoNum, numOfManual);
        OutputView.printBuyLotto(buyLottos); // 생성 로또 보여주기

        WinLotto winLottoAll = genWinLotto();
        LottoMatch lottoMatch = new LottoMatch();
        lottoMatch.checkRank(buyLottos,winLottoAll);

        OutputView.printLottoResult();
        OutputView.printRank(lottoMatch.getRankOfLotto());
        OutputView.printCalProfit(lottoMatch.getRankOfLotto(), priceOfLotto);
    }

    private static WinLotto genWinLotto(){
        Lotto winLottoNum = new Lotto(StringToListConverter.toList(InputView.numberOfWinLotto()));
        BonusNum bonusNum = new BonusNum(StringToIntConverter.toInt(InputView.numberOfBonus()));
        return new WinLotto(winLottoNum, bonusNum);
    }

    private static BuyLottos genBuyLottos(int priceOfLotto, int numOfManual){
        List<String> listOfManual = InputView.numberOfManual(numOfManual);
        BuyLottos buyLottos = new BuyLottos(priceOfLotto, listOfManual);
        buyLottos.buyLottos();  // 로또 생성.
        return buyLottos;
    }

}
