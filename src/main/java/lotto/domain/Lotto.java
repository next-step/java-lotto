package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto() {
        this(new TreeSet<>(LottoFactory.generateLotto()));
    }

    public Lotto(String value) {
        this(splitAndParseInt(value));
    }

    public Lotto(Integer... numbers) {
        this(new TreeSet<>(Arrays.asList(numbers)));
    }

    public Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableSet(numbers);
    }

    private static Set<Integer> splitAndParseInt(String value) {
        String[] split = getSplit(value);
        Set<Integer> numbers = strToIntSet(split);
        return numbers;
    }

    private static Set<Integer> strToIntSet(String[] split) {
        Set<Integer> numbers = new TreeSet<>();
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static String[] getSplit(String value) {
        return value.split(",");
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
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

    private Set<Integer> numbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
