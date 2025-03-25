package domain;

import utils.InputView;

import java.util.ArrayList;
import java.util.List;

import static utils.OutputView.*;

public class LottoGame {

    public void run() {
        String amountInput = InputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(Integer.parseInt(amountInput));
        int lottoCount = purchaseAmount.countOfLotto();

        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generator.generate();
            Lotto lotto = LottoMachine.create(numbers);
            lottos.add(lotto);
        }

        printPurchasedLottos(lottos);

        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers());
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumber);

        printStatistics(statistics);
        printProfitRate(statistics.calculateProfitRate(Integer.parseInt(amountInput)));
    }
}