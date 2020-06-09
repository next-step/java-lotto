package step2;

import step2.model.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoApplication {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    public static void main(String[] args) {
        MoneyAmount purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoNo = InputView.getManualCount();
        List<Lotto> manualLottos = InputView.getManualLottoNumber(manualLottoNo);

        LottoTicket lottoTicket = LOTTO_MACHINE.buyTicket(purchaseAmount, manualLottos);

        ResultView.printTickets(lottoTicket);

        WinningNumbers winningNumbers = WinningNumbers.create(InputView.getWinningNumbers(), InputView.getBonusNumber());

        MatchResult matchResult = lottoTicket.calculateMatchResult(winningNumbers);
        ResultView.printMatchResult(matchResult);

        MatchReport matchReport = MatchReport.create(purchaseAmount, matchResult);
        ResultView.printMatchReport(matchReport);
    }
}
