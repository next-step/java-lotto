package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        long price = InputView.inputPrice();
        LottoTicketForms lottoTicketForms = InputView.inputManualLotto();

        Buyer buyer = Buyer.of(Money.of(price), lottoTicketForms);

        ResultView.printLottoTickets(buyer.getLottoTickets());

        LottoNumbers winningNumbers = LottoNumbers.of(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());
        BuyerResult buyerResult = buyer.getResult(WinningLotto.of(bonusNumber, winningNumbers));

        ResultView.printWinningStatistics(buyerResult);
    }
}
