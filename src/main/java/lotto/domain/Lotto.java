package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this(LottoFactory.generateLotto());
    }

    public Lotto(String value) {
        this(splitAndParseInt(value));
    }

    private static List<Integer> splitAndParseInt(String value) {
        String[] split = getSplit(value);
        List<Integer> numbers = strToInt(split);
        return numbers;
    }

    private static List<Integer> strToInt(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static String[] getSplit(String value) {
        return value.split(",");
    }

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if (noDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        boolean invalidNumber = numbers.stream()
                .anyMatch(n -> n < 1 || n > 45);
        if (invalidNumber) {
            throw new IllegalArgumentException();
        }
    }

    public int match(Lotto winningLotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningLotto.numbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
