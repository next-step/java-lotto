package lotto.domain;

import lotto.dto.LottoDto;

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

    public LottoDto generateReport() {
        return new LottoDto(numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList()));
    }

    public int matches(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }
}
