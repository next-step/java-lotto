package lotto;

import lotto.application.strategy.RandomGenerator;
import lotto.domain.Lotto;
import lotto.application.LottoProgram;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInterface {
    public void start() {
        int lottoPurchaseAmount = InputView.getLottoTicketPurchaseAmountFromUser();
        Lotto.validatePurchaseAmount(lottoPurchaseAmount);

        int lottoTicketQuantityPurchased = OutputView.printLottoTicketQuantityPurchased(lottoPurchaseAmount);

        LottoProgram lottoProgram = new LottoProgram(new RandomGenerator());
        List<Lotto> lottos = lottoProgram.generateLottos(lottoTicketQuantityPurchased);
        OutputView.printLottos(lottos);

        String[] lastWinningLottoNumberInput = InputView.getLastWinningLottoNumbers();
        OutputView.printWinningStatistics(lottoPurchaseAmount, lottoProgram.createWinningStatistics(lottos, lastWinningLottoNumberInput));
    }

    public static void main(String[] args) {
        LottoInterface lottoInterface = new LottoInterface();
        lottoInterface.start();
    }

}
