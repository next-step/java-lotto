package lotto;

import lotto.application.strategy.RandomGenerator;
import lotto.domain.LottoNumbers;
import lotto.application.LottoProgram;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInterface {
    public void start() {
        int lottoTicketPurchaseAmount = InputView.getLottoTicketPurchaseAmountFromUser();
        int lottoTicketQuantityPurchased = OutputView.printLottoTicketQuantityPurchased(lottoTicketPurchaseAmount);

        LottoProgram lottoProgram = new LottoProgram(new RandomGenerator());
        List<LottoNumbers> lottoTickets = lottoProgram.generateLottoTickets(lottoTicketQuantityPurchased);
        OutputView.printLottoTickets(lottoTickets);

        String[] lastWinningLottoNumberInput = InputView.getLastWinningLottoNumbers();
        OutputView.printWinningStatistics(lottoTicketPurchaseAmount, lottoProgram.getWinningStatistics(lottoTickets, lastWinningLottoNumberInput));
    }

    public static void main(String[] args) {
        LottoInterface lottoInterface = new LottoInterface();
        lottoInterface.start();
    }

}
