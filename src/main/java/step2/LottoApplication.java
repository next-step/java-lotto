package step2;

import step2.game.Ticket;
import step2.game.WinningLotto;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int ticketAmount = InputView.buyTicket();
        int manualLottoCount = InputView.buyManual();
        int autoCount = Ticket.verifyAutoCount(ticketAmount, manualLottoCount);

        List<String> manualNumbers = InputView.buyManual(manualLottoCount);
        Ticket ticket = new Ticket(autoCount, manualNumbers);

        ResultView.printTickets(ticket);

        WinningLotto winningLottoNumber
                = new WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        ResultView.printAnalysis(ticket, winningLottoNumber);
    }
}
