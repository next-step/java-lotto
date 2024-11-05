package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int TOTAL_PER_LOTTO = 6;

    private final Set<LottoNumber> numbers;

    public LottoNumbers() {
        this(new LottoRandomGenerator());
    }

    public LottoNumbers(LottoRandomGenerator generator) {
        this(generator.generate(TOTAL_PER_LOTTO));
    }

    public LottoNumbers(String text) {
        this(parse(text));
    }

    public LottoNumbers(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    private static Set<LottoNumber> parse(String text) {
        if (isEmpty(text)) {
            throw new IllegalArgumentException();
        }
        Set<LottoNumber> result = Arrays.stream(text.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validate(result);
        return result;
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != TOTAL_PER_LOTTO) {
            throw new IllegalArgumentException();
        }
    }
}
