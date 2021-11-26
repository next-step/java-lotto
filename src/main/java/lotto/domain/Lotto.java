package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Lotto {
    private static final int BOUND = 46;
    private static final int COUNT = 6;
    private static final Random r = ThreadLocalRandom.current();

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        this(createByStrings(numbers));
    }

    public static Lotto createByAuto() {
        List<LottoNumber> numbers = r.ints(1, BOUND)
            .distinct()
            .limit(COUNT)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(LottoNumber::getNumber));
        return new Lotto(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private static List<LottoNumber> createByStrings(String numbers) {
        List<LottoNumber> byStrings = Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return byStrings;
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }

        Set<LottoNumber> nonDuplicatedNumber = new HashSet<>(numbers);

        if (nonDuplicatedNumber.size() != COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
