package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        long paidAmount = InputView.readPurchaseAmount();
        int totalLottoCount = LottoTicket.getLottoTicketCount(paidAmount);
        int manualLottoCount = InputView.readManualLottoCount();

        List<LottoTicket> manualLottoTickets = InputView.readManualLottoTickets(manualLottoCount);
        Lotto lotto = new Lotto(manualLottoTickets);
        lotto.generateAutoLottoTickets(totalLottoCount - manualLottoCount);
        ResultView.printLottoTickets(lotto, manualLottoCount);

        List<LottoNumber> winningNumbers = InputView.readWinningNumbers();
        LottoNumber bonusBall = InputView.readBonusBall();
        ResultView.printWinningStatistics(lotto.getWinningStat(winningNumbers, bonusBall), lotto);
    }

}
