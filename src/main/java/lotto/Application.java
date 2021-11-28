package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.dto.LottoResultDto;
import lotto.domain.dto.WinningNumberDto;
import lotto.view.LottoTicketPrintView;
import lotto.view.PaymentView;
import lotto.view.WinnerNumberView;
import lotto.view.WinningResultView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();

        int purchaseAmount = PaymentView.inputPurchaseAmount();
        int manualCount = PaymentView.inputManualCount();
        Money money = Money.of(purchaseAmount, manualCount);
        List<String> manualLottoNumbers = PaymentView.inputManualLottoNumbers(manualCount);

        LottoTickets lottoTickets = lottoController.buyLottoTickets(money, manualLottoNumbers);
        LottoTicketPrintView.printLottoTickets(lottoTickets, money);
        WinningNumberDto winnerNumber = WinnerNumberView.getWinningNumberDto();

        LottoResultDto dto = lottoController.lottoResult(lottoTickets, winnerNumber);
        WinningResultView.resultView(dto);
    }

}
