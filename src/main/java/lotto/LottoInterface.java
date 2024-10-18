package lotto;

import lotto.application.strategy.RandomGenerator;
import lotto.domain.Lotto;
import lotto.application.LottoProgram;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInterface {
    public void start() {
        LottoPrice lottoPurchaseAmount = new LottoPrice(InputView.getLottoTicketPurchaseAmountFromUser());

        int lottoTicketQuantityPurchased = OutputView.printLottoTicketQuantityPurchased(lottoPurchaseAmount);

        LottoProgram lottoProgram = new LottoProgram(new RandomGenerator());
        List<Lotto> lottos = lottoProgram.generateLottos(lottoTicketQuantityPurchased);
        OutputView.printLottos(lottos);

        String[] lastWinningLottoNumberInput = InputView.getLastWinningLottoNumbers();
        int bonusBall = InputView.getBonusBallFromUser();

        OutputView.printWinningStatistics(
                lottoPurchaseAmount,
                lottoProgram.createWinningStatistics(lottos, lastWinningLottoNumberInput, new LottoNumber(bonusBall)));
    }

    public static void main(String[] args) {
        LottoInterface lottoInterface = new LottoInterface();
        lottoInterface.start();
    }

}
