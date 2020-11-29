package lotto.controller;

import lotto.model.*;
import lotto.model.lotto.*;
import lotto.strategy.ManualStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;
import util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {

    private Amount amount;
    private LottoPrice lottoPrice;
    private Lottoes lottoes;
    private WinningLotto winningLotto;

    public void run() {
        String inputAmount = InputView.printInputMessageNGetAmount();
        amount = new Amount(inputAmount);

        String manualCount = InputView.printInputManualLottoCountMessageNGetCount();
        lottoPrice = new LottoPrice(amount.getPrePurchaseAmount(0, Lotto.PRICE), manualCount);

        List<String> userInputs = InputView.printInputManualLottoesMessageNGetUserInput(Integer.valueOf(manualCount));
        buyLottoes(userInputs);

        String inputWinnerNumber = InputView.printInputMessageNGetWinnerNumbers();
        String inputBonusNumber = InputView.printInputMessageNGetBonusNumbers();

        winningLotto = new WinningLotto(
                LottoNumber.of(StringUtils.stringToInt(inputBonusNumber)),
                new ManualStrategy(inputWinnerNumber)
        );

        lottery();
    }

    private void buyLottoes(List<String> userInputs) {
        lottoes = new Lottoes(lottoPrice.autoPrice(), userInputs);
        amount.pay(lottoPrice.manualPrice());
        amount.pay(lottoPrice.autoPrice());

        ResultView.printMessage(lottoPrice.toString());
        ResultView.printMessage(lottoes.toString());
    }

    private void lottery() {
        Map<Hit, Integer> winnerNumbers = winningLotto.matches(lottoes);
        double earningRate = winningLotto.earningRate(lottoes, lottoPrice);

        ResultView.printResult(winnerNumbers);
        ResultView.printEarningRate(earningRate);
    }

}
