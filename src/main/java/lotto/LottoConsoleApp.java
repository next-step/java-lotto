package lotto;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsoleApp {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoTicket lottoTicket = LottoTicketMachine.purchase(purchaseAmount);
        lottoTicket.publish();

        ResultView.printLottoCounts(lottoTicket.getLottosCount());
        ResultView.printLottos(lottoTicket.getLottos());

        List<Integer> winningNumbers = InputView.inputLastWinningNumbers();

        ResultView.printWinningStatistics(lottoTicket, winningNumbers);
    }
}
