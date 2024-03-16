package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private static final int RANDOM_BOUND_NUMBER = 45;
    private static final Random RANDOM = new Random();
    private List<Number> numbers;

    public Lotto() {
        this.numbers = createNumbers();
    }

    public Lotto(List<Integer> winNumbers) {
        numbers = new ArrayList<>();
        winNumbers.forEach(number -> numbers.add(new Number(number)));
    }

    private static List<Number> createNumbers() {
        List<Number> newNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            addNumber(newNumbers);
        }
        return newNumbers;
    }

    private static void addNumber(List<Number> newNumbers) {
        Number newNumber = new Number(RANDOM.nextInt(RANDOM_BOUND_NUMBER) + 1);
        validateDuplicateNumber(newNumbers, newNumber);

    }

    private static void validateDuplicateNumber(List<Number> newNumbers, Number newNumber) {
        long count = newNumbers.stream()
                .filter(number -> number.getValue() == newNumber.getValue())
                .count();
        if (count > 0) {
            addNumber(newNumbers);
            return;
        }
        newNumbers.add(newNumber);
    }

    public int getNumberSize() {
        return numbers.size();
    }

    public long compareWinNumber(Lotto winNumber) {
        return numbers.stream()
                .filter(number -> winNumber.contains(number))
                .count();
    }

    private boolean contains(Number number) {
        return this.numbers.contains(number);
    }
}
