package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final String DELIMITER = ", ";

    public static void run() {
        int amount = InputView.inputAmount();
        int quantity = amount / PRICE_OF_LOTTO;
        OutputView.outputQuantity(quantity);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.issueLottos(quantity, new AutoLottoNumberGenerator());

        OutputView.outputLottos(lottoMachine.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers(DELIMITER);

        LottoWinningMachine winningMachine = new LottoWinningMachine();
        Map<Rank, Integer> rankCounts = winningMachine.start(new Lotto(winningNumbers), lottoMachine.getLottos());
        OutputView.outputWinningResult(rankCounts);
        OutputView.outputRateOfResult(winningMachine.calculateRateOfResult(rankCounts, amount));

    }
}
