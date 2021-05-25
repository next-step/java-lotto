package lotto.controllers;

import lotto.Lotto;
import lotto.domains.Ticket;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class WinningTicketController implements Controller {

    private Lotto lotto;

    public WinningTicketController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        Display.show(Message.WINNING_TICKET);

        saveWinningTicket(Keyboard.read());

        toBonusNumberController();
    }

    protected void saveWinningTicket(String numbers) {
        Ticket ticket = new Ticket(numbers);
        this.lotto.storage().saveWinningTicket(ticket);
    }

    private void toBonusNumberController() {
        this.lotto.toBonusNumberController();
    }
}
