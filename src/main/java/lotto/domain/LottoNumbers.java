package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final Set<LottoNumber> numbers;

    public LottoNumbers(String text) {
        this(parse(text));
    }

    public LottoNumbers(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public WinningRule matchRule(LottoNumbers numbers) {
        long count = numbers.getNumbers().stream().filter(this.numbers::contains).count();
        return WinningRule.findByValue((int)count);
    }

    public List<LottoNumber> notMatchedNumbers(LottoNumbers numbers) {
        return numbers.getNumbers().stream().filter(n -> !this.numbers.contains(n)).collect(Collectors.toList());
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
