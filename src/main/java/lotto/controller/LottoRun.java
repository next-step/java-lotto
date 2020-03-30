package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoRun {

    private static final LottoResultView lottoResultView = new LottoResultView();

    public static void main(String[] args) {
        Money myMoney = getMonney();

        List<Lotto> myLottos = purchaseLottos(myMoney);

        Lotto winningLotto = getWinningLotto();

        insightResult(myMoney, winningLotto, myLottos);
    }

    private static Money getMonney() {
        int money = lottoResultView.inputMoney();
        return new Money(money);
    }

    private static List<Lotto> purchaseLottos(Money money) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(money);
        lottoResultView.viewLottos(lottos);

        return lottos;
    }

    private static Lotto getWinningLotto() {
        String winningNumbers = lottoResultView.inputWinningNumber();
        Lotto winningLotto = Lotto.newManual(winningNumbers);
        lottoResultView.viewLottoNumbers(winningLotto);

        return winningLotto;
    }

    private static LottoInspector insightResult(Money money, Lotto winningLotto, List<Lotto> lottos) {
        LottoInspector lottoInspector = new LottoInspector();
        Map<Integer, Integer> result = lottoInspector.getResult(winningLotto, lottos);
        int totalRevenue = lottoInspector.getTotalRevenue(result);
        BigDecimal yield = lottoInspector.getYield(money, totalRevenue);

        lottoResultView.viewInspect(result);
        lottoResultView.viewInsight(yield);

        return lottoInspector;
    }
}
