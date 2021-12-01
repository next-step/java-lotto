package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Lotto {
    private static final int COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        this(createNonDuplicatedBy(numbers));
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private static List<LottoNumber> createNonDuplicatedBy(String numbers) {
        List<LottoNumber> byStrings = Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return byStrings;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }

        Set<LottoNumber> nonDuplicatedNumber = new HashSet<>(numbers);

        if (nonDuplicatedNumber.size() != COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
