package lotto.domains;

import lotto.exceptions.NumberOutOfBoundsException;
import lotto.tool.Converter;

public class BonusNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private int bonusNumber;

    public BonusNumber(String text) {
        int number = Converter.toInteger(text);

        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new NumberOutOfBoundsException();
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
