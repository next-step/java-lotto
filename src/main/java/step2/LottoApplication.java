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
        Ticket ticket = new Ticket(ticketAmount, manualLottoCount);

        List<String> manualNumbers = InputView.buyManual(manualLottoCount);
        ticket.buyManuals(manualNumbers);

        ResultView.printTickets(ticket);

        WinningLotto winningLottoNumber
                = new WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        ResultView.printAnalysis(ticket, winningLottoNumber);
    }
}
