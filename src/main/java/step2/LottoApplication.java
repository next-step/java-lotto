package step2;

import step2.domain.LottoGame;
import step2.domain.LottoNumber;
import step2.domain.Ticket;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        OutputView.printPriceNotification();
        Ticket ticket = Ticket.from(InputView.inputPrice());
        int ticketCount = ticket.getTicketCount();
        OutputView.printPurchaseResult(ticketCount);
        LottoGame lottoGame = LottoGame.newInstance();
        List<LottoNumber> lottoNumbers = lottoGame.playLotto(ticketCount);
        OutputView.printLottoNumbers(lottoNumbers);
        int[] winningNumbers = InputView.inputWinningNumbers();
    }
}
