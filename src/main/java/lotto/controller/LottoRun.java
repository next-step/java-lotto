package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoRun {
    private static final ResultView resultView = new ResultView();
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        Money myMoney = getMonney();

        List<Lotto> myLottos = purchaseLottos(myMoney);

        WinningLotto winningLotto = getWinningLotto();

        Map<RankEnum, Integer> result = insightResult(winningLotto, myLottos);
        insightYield(myMoney, result);
    }

    private static Money getMonney() {
        int money = inputView.inputMoney();
        return new Money(money);
    }

    private static List<Lotto> purchaseLottos(Money money) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(money);
        resultView.viewLottos(lottos);

        return lottos;
    }

    private static WinningLotto getWinningLotto() {
        String winningNumbers = inputView.inputWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static Map<RankEnum, Integer> insightResult(WinningLotto winningLotto, List<Lotto> lottos) {
        LottoInspector lottoInspector = new LottoInspector();
        Map<RankEnum, Integer> result = lottoInspector.getResult(winningLotto, lottos);

        resultView.viewInspect(result);

        return result;
    }

    private static LottoInspector insightYield(Money money, Map<RankEnum, Integer> result) {
        LottoInspector lottoInspector = new LottoInspector();
        int totalRevenue = lottoInspector.getTotalRevenue(result);
        BigDecimal yield = lottoInspector.getYield(money, totalRevenue);

        resultView.viewInsight(yield);

        return lottoInspector;
    }
}
