package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void startLotto() {
        int money = getMoney();
        int passiveCount = getPassiveCount();
        int totalCount = getTotalCount(money, passiveCount);
        int autoCount = totalCount - passiveCount;
        Lottos lottos = LottoGenerator
                .createLottos(InputView.inputPassiveLottoNumbers(passiveCount), autoCount);

        ResultView.printPassiveAndAutoCount(passiveCount, autoCount);
        ResultView.printLotto(lottos);

        List<Integer> winNumbers = getWinNumbers();
        int bonus = getBonus();

        proceedMatch(lottos, winNumbers, bonus);

        Map<Rank, Integer> matchResult = Rank.getMatchResult();
        ResultView.printResult(matchResult, getRevenue(money, matchResult));
    }

    private static int getMoney() {
        return InputView.inputMoney();
    }

    private static int getPassiveCount() {
        return InputView.inputPassiveLottoCount();
    }

    private static int getTotalCount(int money, int passiveCount) {
        return new LottoShop(money).calculateTotalPurchaseCount(passiveCount);
    }

    private static List<Integer> getWinNumbers() {
        return StringUtils.parseWinNumbers(InputView.inputWinNumbers());
    }

    private static int getBonus() {
        return InputView.inputBonus();
    }

    private static void proceedMatch(Lottos lottos, List<Integer> winNumbers, int bonus) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank.putMatchResult(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonus)));
        }
    }

    private static double getRevenue(int money, Map<Rank, Integer> matchResult) {
        LottoRevenue lottoRevenue = new LottoRevenue();
        return lottoRevenue.calculateRevenue(money, lottoRevenue.revenueTotal(matchResult));
    }
}
