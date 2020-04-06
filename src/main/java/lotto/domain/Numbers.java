package lotto.domain;

import lotto.exception.NotANumberException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.OutOfRangeException;
import lotto.util.LottoTicketUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    private final Set<Integer> number;
    private int bonusNumber;

    public Numbers(List<Integer> inputNumber) {
        checkLengthValidation(inputNumber);
        this.number = new HashSet<>(inputNumber);
        checkNumberValidation(number);
        checkDuplicate(number);
    }


    public Set<Integer> showNumbers() {
        return number.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private void checkLengthValidation(List<Integer> numberInformation) {
        if (numberInformation.size() != LottoTicketUtils.RANGE) {
            throw new OutOfRangeException();
        }
    }

    private Set<Integer> checkNumberValidation(Set<Integer> numbers) {
        for (int number : numbers) {
            checkNumberRange(number);
        }
        return numbers;
    }

    private void checkDuplicate(Set<Integer> inputNumber) {
        if (inputNumber.size() < 6) {
            throw new NumberDuplicateException();
        }
    }

    private void checkNumberRange(int number) {
        if (number < LottoTicketUtils.TICKET_MIN_NUMBER || number > LottoTicketUtils.TICKET_MAX_NUMBER) {
            throw new NotANumberException(number);
        }
    }

}
