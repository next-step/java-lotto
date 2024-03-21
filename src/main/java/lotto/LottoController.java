package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        Amount amount = new Amount(InputView.askPurchaseAmount());
        LottoTickets lottoTickets = new LottoTickets(amount);
        ResultView.printLottoTickets(lottoTickets);

        LottoTicket winningNumbers = new LottoTicket(InputView.askWinningNumbers().split(", "));
        LottoNumber bonusBall = new LottoNumber(InputView.askBonusBall());

        ResultView.printWinningStatistics(lottoTickets, winningNumbers, bonusBall);
        ResultView.printEarningsRate(lottoTickets, winningNumbers, bonusBall);
    }
}
