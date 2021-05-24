package lotto.controllers;

import lotto.BonusNumber;
import lotto.Lotto;
import lotto.Ticket;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class BonusNumberController implements Controller {

    private Lotto lotto;

    public BonusNumberController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        Display.show(Message.BONUS_NUMBER);

        saveBonusNumber(Keyboard.read(), loadWinningTicket());

        toResultController();
    }

    protected void saveBonusNumber(String number, Ticket winningTicket) {
        BonusNumber bonusNumber = new BonusNumber(number, winningTicket);
        this.lotto.storage().saveBonusNumber(bonusNumber);
    }

    private Ticket loadWinningTicket() {
        return this.lotto.storage().loadWinningTicket();
    }

    private void toResultController() {
        this.lotto.toResultController();
    }
}
