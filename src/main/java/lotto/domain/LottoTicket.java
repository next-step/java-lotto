package lotto.domain;

import lotto.exception.NotANumberException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.OutOfRangeException;
import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> ticket;

    public LottoTicket() {
        this(autoNumberGenerate());
    }

    public LottoTicket(List<Integer> numbers) {
        checkLengthValidation(numbers);
        this.ticket = checkNumberValidation(numbers);
    }

    public List<Integer> showTicketNumber() {
        return ticket;
    }

    public int findMatchCount(LottoTicket lottoWinningTicket) {
        List<Integer> copyList = new ArrayList<>(lottoWinningTicket.showTicketNumber());
        copyList.removeAll(ticket);
        return LottoTicketUtils.RANGE - copyList.size();
    }

    private static List<Integer> autoNumberGenerate() {
        List<Integer> lotto = new ArrayList<>();

        Collections.shuffle(LottoTicketUtils.lottoNumberRange);
        List<Integer> randomNumber = LottoTicketUtils.lottoNumberRange.subList(0, LottoTicketUtils.RANGE);

        for (Integer number : randomNumber) {
            lotto.add(number);
        }

        Collections.sort(lotto);
        return lotto;
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

    public boolean hasBonusNumber(int bonusNumber) {
        return ticket.contains(bonusNumber);
    }
}
