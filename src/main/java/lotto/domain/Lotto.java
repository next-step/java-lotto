package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto(Integer... numbers) {
        if (numbers.length != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException();

        this.numbers = Arrays.stream(numbers)
                .peek(this::validNumber)
                .collect(Collectors.toSet());
    }

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void validNumber(Integer number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER)
            throw new IllegalArgumentException();
    }

    public int sameNumberCount(Lotto lotto) {
        Set<Integer> resultNumbers = new HashSet<>(this.numbers);
        Set<Integer> compareNumbers = lotto.getNumbers();
        resultNumbers.retainAll(compareNumbers);
        return resultNumbers.size();
    }
}
