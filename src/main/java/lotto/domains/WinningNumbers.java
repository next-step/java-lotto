package lotto.domains;

import lotto.enums.ErrorMessage;
import lotto.enums.Prize;
import lotto.exceptions.DuplicateNumbersException;

public class WinningNumbers {

    private Ticket winningTicket;
    private BonusNumber bonusNumber;

    public WinningNumbers(Ticket winningTicket, BonusNumber bonusNumber) {
        if (bonusNumber.isExist(winningTicket)) {
            throw new DuplicateNumbersException(ErrorMessage.DUPLICATE_NUMBERS.toString());
        }

        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public Prize classifyPrize(Ticket ticket) {
        int count = ticket.countSameNumbers(this.winningTicket);

        if (this.bonusNumber.isExist(ticket) && count == Prize.FIVE.getIndex()) {
            return Prize.BONUS;
        }

        return Prize.valueOf(count);
    }

    @Override
    public String toString() {
        return this.winningTicket + " " + this.bonusNumber;
    }

}
