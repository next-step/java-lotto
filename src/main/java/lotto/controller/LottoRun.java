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

        LottoInspector lottoInspector = innsightLottos(winningLotto, myLottos);

        innsightResult(lottoInspector, myMoney);
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

    private static LottoInspector innsightLottos(Lotto winningLotto, List<Lotto> lottos) {
        LottoInspector lottoInspector = new LottoInspector(winningLotto, lottos);
        Map<Integer, Integer> result = lottoInspector.getMatchedResult();
        lottoResultView.viewInspect(result);

        return lottoInspector;
    }

    private static BigDecimal innsightResult(LottoInspector lottoInspector, Money money) {
        int totalRevenue = lottoInspector.getTotalRevenue();
        BigDecimal yield = lottoInspector.getYield(money, totalRevenue);
        lottoResultView.viewInsight(yield);

        return yield;
    }
}
