package lotto.domain;

import lotto.exception.NotANumberException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.OutOfRangeException;
import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> number;
    private int bonusNumber;

    public Numbers(List<Integer> number) {
        checkLengthValidation(number);
        this.number = checkNumberValidation(number);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void checkLengthValidation(List<Integer> numberInformation) {
        if (numberInformation.size() != LottoTicketUtils.RANGE) {
            throw new OutOfRangeException();
        }
    }

    private List<Integer> checkNumberValidation(List<Integer> numbers) {
        List<Integer> tmpList = new ArrayList<>();
        for (int number : numbers) {
            checkNumberRange(number);
            checkDuplicate(tmpList, number);
        }
        return numbers;
    }

    private void checkDuplicate(List<Integer> tmpList, int number) {
        if (tmpList.contains(number)) {
            throw new NumberDuplicateException();
        }
        tmpList.add(number);

    }

    private void checkNumberRange(int number) {
        if (number < LottoTicketUtils.TICKET_MIN_NUMBER || number > LottoTicketUtils.TICKET_MAX_NUMBER) {
            throw new NotANumberException(number);
        }
    }

}
