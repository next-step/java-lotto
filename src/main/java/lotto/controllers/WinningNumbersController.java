package lotto.controllers;

import lotto.Lotto;
import lotto.domains.BonusNumber;
import lotto.domains.Ticket;
import lotto.domains.WinningNumbers;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class WinningNumbersController implements Controller {

    private Lotto lotto;

    public WinningNumbersController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        Ticket winningTicket = askWinningTicket();
        BonusNumber bonusNumber = askBonusNumber();

        saveWinningNumbers(winningTicket, bonusNumber);
    }

    private Ticket askWinningTicket() {
        Display.show(Message.WINNING_TICKET);
        return new Ticket(Keyboard.read());
    }

    private BonusNumber askBonusNumber() {
        Display.show(Message.BONUS_NUMBER);
        return new BonusNumber(Keyboard.read());
    }

    protected void saveWinningNumbers(Ticket ticket, BonusNumber number) {
        WinningNumbers winningNumbers = new WinningNumbers(ticket, number);
        this.lotto.storage().saveWinningNumbers(winningNumbers);
    }

}
