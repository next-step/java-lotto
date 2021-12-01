package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class LottoNumberFactory {
    private static final int BASE = 1;
    private static final int BOUND = 46;
    private static final int COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoNumberFactory() {
        this.numbers = createLottoNumbers();
    }

    public List<LottoNumber> getNonDuplicated() {
        Collections.shuffle(this.numbers);
        List<LottoNumber> numbers = this.numbers.stream()
            .limit(this.COUNT)
            .collect(Collectors.toList());
        validateDuplicate(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public List<LottoNumber> getNonDuplicated(String numbers) {
        List<LottoNumber> byStrings = Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        validateDuplicate(byStrings);
        return Collections.unmodifiableList(byStrings);
    }

    private List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> numbers = IntStream.range(BASE, BOUND)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(LottoNumber::getNumber));
        return numbers;
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
    }
}

