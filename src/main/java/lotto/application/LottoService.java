package lotto.application;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoService {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoService(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void purchase() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(inputView.inputPurchaseMoney());
        Lottos lottos = purchaseLottos(purchaseMoney);

        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputWinningNumbers());
        LottoStatistics lottoStatistics = new LottoStatistics();
        AccordanceCount accordanceCount = lottoStatistics.collectAccordanceCount(lottos, winningNumbers);
        resultView.printWinningStatistics(accordanceCount);

        double profitRatio = lottoStatistics.calculateProfitRatio(accordanceCount, purchaseMoney);
        resultView.printProfitRatio(profitRatio);
    }

    private Lottos purchaseLottos(PurchaseMoney purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.purchase(purchaseMoney);
        resultView.printLottos(lottos);

        return lottos;
    }

}
