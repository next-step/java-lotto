package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsoleApp {

    public static void main(String[] args) {
        final int purchaseAmount = InputView.inputPurchaseAmount();

        final LottoTicket lottoTicket = LottoTicketMachine.purchase(purchaseAmount);

        ResultView.printLottoCounts(lottoTicket.getLottos().size());
        ResultView.printLottos(lottoTicket.getLottos());

        final List<Integer> winningNumbers = InputView.inputLastWinningNumbers();
        final Map<Integer, List<Lotto>> winningResult = lottoTicket.getWinningResult(winningNumbers);

        ResultView.printWinningStatistics(winningResult);

        ResultView.printEarningsRate(lottoTicket.getEarningsRate(winningResult, purchaseAmount));
    }
}
