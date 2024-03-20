package lotto.controller;

import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoStatisticComputer;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    private LottoStatisticComputer lottoStatisticComputer;


    public void buyLotto() {
        Budget budget = InputView.inputBuyBudget();
        List<Lotto> lottos = lottoGenerator.generateLottos(budget);
        ResultView.showGeneratedLottos(lottos);
        lottoStatisticComputer = new LottoStatisticComputer(lottos);
        ResultView.showStatistic(lottoStatisticComputer.computeStatistic(InputView.inputLastWinLotto(), budget));
    }

}
