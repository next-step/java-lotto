package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    public static void startLotto() {
        int money = InputView.inputMoney();
        Lottos lottos = LottoGenerator.createLottos(new LottoShop(money).calculatePurchaseCount());
        ResultView.printLotto(lottos);

        List<Integer> winNumbers = StringUtils.parseWinNumbers(InputView.inputWinNumbers());
        int bonus = InputView.inputBonus();

        for (Lotto lotto : lottos.getLottos()) {
            Rank.putMatchResult(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonus)));
        }

        HashMap<Rank, Integer> matchResult = Rank.getMatchResult();
        ResultView.printResult(matchResult, LottoRevenue.calculateRevenue(money, LottoRevenue.revenueTotal(matchResult)));
    }
}
