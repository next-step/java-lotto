package lotto;

import lotto.domain.LottoGame;
import lotto.domain.number.LottoNumber;
import lotto.domain.price.PayInfo;
import lotto.domain.price.Price;
import lotto.domain.price.PurchaseInfo;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.seller.LottoSeller;
import lotto.domain.ticket.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        Price price = Price.of(InputView.inputPurchasePrice());
        int manualTicketsCount = InputView.inputManualTicketsCount();
        List<List<LottoNumber>> manualTicketNumbers = InputView.inputManualTickets2(manualTicketsCount);

        PayInfo payInfo2 = PayInfo.valueOf(price, manualTicketNumbers);
        PurchaseInfo purchaseInfo = LottoSeller.buyTicket2(payInfo2);

        ResultView.printPurchaseInfo2(purchaseInfo);

        List<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(winningNumbers, bonusNumber);

        LottoPrizeResult result2 = LottoGame.of(price, purchaseInfo.getAllTickets()).play(winningLottoTicket);

        ResultView.printResult(result2);
    }
}
