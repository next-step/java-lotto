package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Lotto {
    private static final int bound = 46;
    private static final int count = 6;
    private static final Random r = ThreadLocalRandom.current();

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<LottoNumber> byStrings = createByStrings(numbers);
        validateNumbers(byStrings);
        this.numbers = byStrings;
    }

    public static Lotto createByAuto() {
        List<LottoNumber> numbers = r.ints(1, bound)
            .distinct()
            .limit(count)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(LottoNumber::getNumber));
        return new Lotto(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private List<LottoNumber> createByStrings(String numbers) {
        return Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() > count) {
            throw new IllegalArgumentException();
        }

        int count = (int) numbers.stream()
            .map(LottoNumber::getNumber)
            .distinct()
            .count();

        if (numbers.size() != count) {
            throw new IllegalArgumentException();
        }
    }
}
