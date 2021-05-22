package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.enums.ErrorMessage;
import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.InsufficientNumbersException;
import lotto.exceptions.NumberOutOfBoundsException;

public final class TicketGuard {

    public static final int SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private TicketGuard() {
    }

    public static List<Integer> guard(List<Integer> numbers) {
        guardInsufficientSize(numbers);
        guardOutOfBounds(numbers);
        guardDuplicate(numbers);

        return sort(numbers);
    }

    private static List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private static void guardInsufficientSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new InsufficientNumbersException(ErrorMessage.INSUFFICIENT_NUMBERS.toString());
        }
    }

    private static void guardOutOfBounds(List<Integer> numbers) {
        for (int number : numbers) {
            verifyIndividualBounds(number);
        }
    }

    private static void verifyIndividualBounds(int number) {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new NumberOutOfBoundsException(ErrorMessage.NUMBER_OUT_OF_BOUNDS.toString());
        }
    }

    private static void guardDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new DuplicateNumbersException(ErrorMessage.DUPLICATE_NUMBERS.toString());
        }
    }

}
