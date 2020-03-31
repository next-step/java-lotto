package lotto.domain;

import lotto.exception.NotANumberException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.OutOfRangeException;
import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningTicket {
    private final List<Integer> winningNumber;

    public LottoWinningTicket(List<Integer> numbers) {
        checkLengthValidation(numbers);
        this.winningNumber = checkNumberValidation(numbers);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private void checkLengthValidation(List<Integer> numberInformation) {
        if (numberInformation.size() != LottoTicketUtils.RANGE) {
            throw new OutOfRangeException();
        }
    }

    private List<Integer> checkNumberValidation(List<Integer> numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        for (int number : numbers) {
            checkNumberRange(number);
            checkDuplicateThenAdd(winningNumber, number);
        }
        return winningNumber;
    }

    private void checkDuplicateThenAdd(List<Integer> winningNumber, int number) {
        if (winningNumber.contains(number)) {
            throw new NumberDuplicateException();
        }
        winningNumber.add(number);
    }

    private void checkNumberRange(int number) {
        if (number < LottoTicketUtils.TICKET_MIN_NUMBER || number > LottoTicketUtils.TICKET_MAX_NUMBER) {
            throw new NotANumberException(number);
        }
    }
}
