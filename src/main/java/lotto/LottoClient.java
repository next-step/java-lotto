package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoClient {
    public static void main(String[] args) {
        Amount amount = new Amount(InputView.askPurchaseAmount());
        LottoTickets lottoTickets = new LottoTickets(amount);
        ResultView.printLottoTickets(lottoTickets);
        InputView.askWinningNumbers();
    }
}
