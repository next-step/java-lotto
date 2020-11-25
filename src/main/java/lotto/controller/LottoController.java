package lotto.controller;

import lotto.model.*;
import lotto.model.lotto.*;
import lotto.strategy.ManualStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;
import util.StringUtils;

import java.util.*;

public class LottoController {

    private Amount amount;
    private LottoCount lottoCount;
    private Lottoes lottoes;
    private WinningLotto winningLotto;

    public void run() {
        String inputAmount = InputView.printInputMessageNGetAmount();
        amount = new Amount(inputAmount);

        String manualCount = InputView.printInputManualLottoCountMessageNGetCount();
        lottoCount = new LottoCount(amount.getPrePurchaseAmount(0, Lotto.PRICE), manualCount);

        buyLottoes();

        String inputWinnerNumber = InputView.printInputMessageNGetWinnerNumbers();
        String inputBonusNumber = InputView.printInputMessageNGetBonusNumbers();

        winningLotto = new WinningLotto(
                new LottoNumber(StringUtils.stringToInt(inputBonusNumber)),
                new ManualStrategy(inputWinnerNumber)
        );

        lottery();
    }

    private void buyLottoes() {
        List<CandidateLotto> manualLottos = InputView.printInputManualLottoesMessageNGetManualLotoes(lottoCount.getManualCount());
        amount.pay(lottoCount.getManualCount() * Lotto.PRICE);
        lottoes = new Lottoes(lottoCount.getAutoCount(), Optional.of(manualLottos));
        amount.pay(lottoCount.getAutoCount() * Lotto.PRICE);

        ResultView.printBuyMessage(lottoCount.getManualCount(), lottoCount.getAutoCount());
        ResultView.printLottoes(lottoes.getLottoes());
    }

    private void lottery() {
        int prePurchaseAmount = amount.getPrePurchaseAmount(lottoCount.getTotalCount(), Lotto.PRICE);

        List<LottoTicket> lottoesNumbers = lottoes.getLottoes();
        Map<Hit, Integer> winnerNumbers = winningLotto.getResult(lottoesNumbers);
        double earningRate = winningLotto.getEarningRate(prePurchaseAmount, lottoesNumbers);

        ResultView.printResult(winnerNumbers);
        ResultView.printEarningRate(earningRate);
    }

}
