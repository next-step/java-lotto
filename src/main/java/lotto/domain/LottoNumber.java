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
public class LottoNumber {
    private static final int BASE = 0;
    private static final int BOUND = 45;
    private static final int COUNT = 6;
    private static final Random r = ThreadLocalRandom.current();

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public LottoNumber(String input) {
        this(Integer.parseInt(input));
    }

    public int getNumber() {
        return number;
    }

    public static List<LottoNumber> createNonDuplicated() {
        List<LottoNumber> numbers = r.ints(BASE + 1, BOUND + 1)
            .distinct()
            .limit(COUNT)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(LottoNumber::getNumber));
        return numbers;
    }

    public static List<LottoNumber> createNonDuplicated(String numbers) {
        List<LottoNumber> byStrings = Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return byStrings;
    }

    private void validateNumber(int number) {
        if (number < BASE || number > BOUND) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(number);
        return sb.toString();
    }
}
