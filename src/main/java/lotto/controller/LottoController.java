package lotto.controller;

import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.LottoMachine;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

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

    }
}
