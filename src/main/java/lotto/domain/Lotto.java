package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto() {
        this(LottoFactory.generateLotto());
    }

    public Lotto(String value) {
        this(splitAndParseInt(value));
    }

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(List<Integer> numbers) {
        this(convert(numbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableSet(numbers);
    }

    private static Set<LottoNumber> convert(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    private static List<Integer> splitAndParseInt(String value) {
        String[] split = getSplit(value);
        List<Integer> numbers = strToIntSet(split);
        return numbers;
    }

    private static List<Integer> strToIntSet(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static String[] getSplit(String value) {
        return value.split(",");
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int match(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber number : numbers) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
