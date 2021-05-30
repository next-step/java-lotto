package lotto.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.EmptyNumbersException;
import lotto.exceptions.InsufficientNumbersException;
import lotto.exceptions.NumberOutOfBoundsException;

public final class TicketGuard {

    private static final int SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

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
        if (numbers == null || numbers.isEmpty()) {
            throw new EmptyNumbersException();
        }

        if (numbers.size() != SIZE) {
            throw new InsufficientNumbersException();
        }
    }

    private static void guardOutOfBounds(List<Integer> numbers) {
        for (int number : numbers) {
            guardOutOfBounds(number);
        }
    }

    private static void guardOutOfBounds(int number) {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new NumberOutOfBoundsException();
        }
    }

    private static void guardDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new DuplicateNumbersException();
        }
    }

}
