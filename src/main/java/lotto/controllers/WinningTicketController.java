package lotto.controllers;

import lotto.Lotto;
import lotto.Ticket;
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
        show();

        try {
            action();
            toResultController();
        } catch (Exception e) {
            Display.error(e.getMessage());
        }
    }

    private void show() {
        Display.show(Message.WINNING_TICKET);
    }

    private void action() {
        saveWinningTicket(Keyboard.read());
    }

    protected void saveWinningTicket(String numbers) {
        Ticket ticket = new Ticket(numbers);
        this.lotto.storage().saveWinningTicket(ticket);
    }

    private void toResultController() {
        this.lotto.toResultController();
    }
}
