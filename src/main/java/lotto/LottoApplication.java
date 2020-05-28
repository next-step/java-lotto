package lotto;

import lotto.domain.LottoGame;
import lotto.domain.number.LottoNumber;
import lotto.domain.price.PayInfo;
import lotto.domain.price.Price;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.seller.LottoSeller;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        Price price = Price.of(InputView.inputPurchasePrice());
        int manualTicketsCount = InputView.inputManualTicketsCount();
        LottoTickets manualTickets = InputView.inputManualTickets(manualTicketsCount);

        PayInfo payInfo = PayInfo.valueOf(price, manualTickets);
        LottoTickets tickets = LottoSeller.buyTicket(payInfo);

        ResultView.printPurchaseInfo(payInfo, tickets);

        List<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(winningNumbers, bonusNumber);

        LottoPrizeResult result = LottoGame.of(price, tickets).play(winningLottoTicket);

        ResultView.printResult(result);
    }
}
