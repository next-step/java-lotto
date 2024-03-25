package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoTickets;
import lotto.domain.ManualLottoCount;
import lotto.domain.WinningTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        Amount amount = new Amount(InputView.askPurchaseAmount());
        ManualLottoCount manualLottoCount = new ManualLottoCount(InputView.askManualLottoCount(), amount);
        List<String[]> manualLottoNumbers = InputView.askManualLottoNumbers(manualLottoCount);

        LottoTickets lottoTickets = new LottoTickets(amount, manualLottoNumbers);
        ResultView.printLottoTickets(lottoTickets, manualLottoCount);

        String[] winningNumbers = InputView.askWinningNumbers();
        String bonusBall = InputView.askBonusBall();
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusBall);

        ResultView.printWinningStatistics(lottoTickets.winnerCounts(winningTicket));
        ResultView.printEarningsRate(lottoTickets.earningsRate(winningTicket));
    }

}
