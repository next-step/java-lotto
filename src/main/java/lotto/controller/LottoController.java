package lotto.controller;

import lotto.model.*;
import lotto.strategy.ManualStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;
import util.StringUtils;

import java.util.*;

public class LottoController {

    private Amount amount;
    private Lottoes lottoes;
    private WinningLotto winningLotto;

    public void run() {
        String inputAmount = InputView.printInputMessageNGetAmount();
        amount = new Amount(inputAmount);

        buyLottoes();

        String inputWinnerNumber = InputView.printInputMessageNGetWinnerNumbers();
        String inputBonusNumber = InputView.printInputMessageNGetBonusNumbers();

        winningLotto = new WinningLotto(
                StringUtils.stringToInt(inputBonusNumber),
                new ManualStrategy(inputWinnerNumber)
        );

        lottery();
    }

    private void buyLottoes() {
        lottoes = new Lottoes(amount.getPrePurchaseAmount(0, Lotto.PRICE));
        amount.pay(lottoes.getLottoCount() * Lotto.PRICE);
        ResultView.printBuyMessage(lottoes.getLottoCount());
        ResultView.printLottoes(lottoes.getLottoes());
    }

    private void lottery() {
        int lottoCount = lottoes.getLottoCount();
        int prePurchaseAmount = amount.getPrePurchaseAmount(lottoCount, Lotto.PRICE);

        List<SortedSet<Integer>> lottoesNumbers = lottoes.getLottoes();
        Map<Hit, Integer> winnerNumbers = winningLotto.getResult(lottoesNumbers);
        double earningRate = winningLotto.getEarningRate(prePurchaseAmount, lottoesNumbers);

        ResultView.printResult(winnerNumbers);
        ResultView.printEarningRate(earningRate);
    }

}
