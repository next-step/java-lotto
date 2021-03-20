package step2.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersValid(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersUnique(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    private boolean areNumbersUnique(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).size() == COUNT;
    }

    private boolean areNumbersValid(List<Integer> numbers) {
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        return validFlag;
    }

    public Lotto() {
        this(LottoNumberGenerator.issueNumbers(UPPER_BOUND, COUNT));
    }

    public Lotto(String values) {
        this(Arrays.stream(values.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
