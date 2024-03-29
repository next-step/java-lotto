package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringUtils;
import view.InputView;
import view.ResultView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    public static void startLotto() {
        int money = InputView.inputMoney();
        Lottos lottos = LottoGenerator.createLottos(LottoPurchase.purchase(money));
        ResultView.printLotto(lottos);

        List<Integer> winNumbers = StringUtils.parseWinNumbers(InputView.inputWinNumbers());
        int bonus = InputView.inputBonus();

        for (Lotto lotto : lottos.getLottos()) {
            LottoMatchResult.putMatchResult(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonus)));
        }

        HashMap<Rank, Integer> matchResult = LottoMatchResult.getMatchResult();
        ResultView.printResult(matchResult, LottoRevenue.calculateRevenue(money, LottoRevenue.revenueTotal(matchResult)));
    }
}
