package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.toLotto;
import static lotto.domain.LottoGenerator.validateSize;

public class Lotto {
    private final Set<LottoNumber> numbers;

    public Lotto() {
        this(createLotto());
    }

    public Lotto(String numbers) {
        this(toLotto(numbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private static Set<LottoNumber> createLotto() {
        return LottoGenerator.generate();
    }

    public Set<Integer> generateReport() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public int matches(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }
}
