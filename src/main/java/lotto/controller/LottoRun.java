package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoResultView;

import java.util.List;
import java.util.Map;

public class LottoRun {

    private static final LottoResultView lottoResultView = new LottoResultView();

    public static void main(String[] args) {
        Integer money = lottoResultView.inputMoney();
        Money myMoney = new Money(money);

        List<Lotto> myLottos = purchaseLottos(myMoney);

        WinningLotto winningLotto = getWinningLotto();

        innsightLottos(myMoney, winningLotto, myLottos);
    }

    private static List<Lotto> purchaseLottos(Money money) {
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottos = lottoMachine.getLottos();

        lottoResultView.viewLottoCount(lottos);
        lottoResultView.viewLottos(lottos);

        return lottos;
    }

    private static WinningLotto getWinningLotto() {
        String winningNumbers = lottoResultView.inputWinningNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        lottoResultView.viewLottoNumbers(winningLotto.getWinningLotto());

        return winningLotto;
    }

    private static LottoInspector innsightLottos(Money money, WinningLotto winningLotto, List<Lotto> lottos) {
        LottoInspector lottoInspector = new LottoInspector(winningLotto, lottos);
        Map<Integer, Integer> result = lottoInspector.getMatchedResult();
        lottoResultView.viewInspect(result);

        int totalRevenue = lottoInspector.getTotalRevenue();
        lottoResultView.viewInsight(money, totalRevenue);

        return lottoInspector;
    }
}
