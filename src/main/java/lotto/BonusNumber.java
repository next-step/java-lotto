package lotto;

import lotto.enums.ErrorMessage;
import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.NumberOutOfBoundsException;
import lotto.tool.Converter;

public class BonusNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int bonusNumber;

    public BonusNumber(String text, Ticket winningTicket) {
        int number = Converter.toInteger(text);

        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new NumberOutOfBoundsException(ErrorMessage.NUMBER_OUT_OF_BOUNDS.toString());
        }

        if (winningTicket.contains(number)) {
            throw new DuplicateNumbersException(ErrorMessage.DUPLICATE_NUMBERS.toString());
        }

        this.bonusNumber = number;
    }

    public boolean isExist(Ticket ticket) {
        return ticket.contains(this.bonusNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(bonusNumber);
    }
}
