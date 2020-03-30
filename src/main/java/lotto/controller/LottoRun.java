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

        WinningLotto winningLotto = getWinningLotto();

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

    private static WinningLotto getWinningLotto() {
        String winningNumbers = lottoResultView.inputWinningNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        lottoResultView.viewLottoNumbers(winningLotto.getWinningLotto());

        return winningLotto;
    }

    private static LottoInspector innsightLottos(WinningLotto winningLotto, List<Lotto> lottos) {
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
