package lotto.domain;

import lotto.dto.LottoDto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.toLotto;
import static lotto.domain.LottoGenerator.validateSize;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto() {
        this(createLotto());
    }

    public Lotto(String numbers) {
        this(toLotto(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private static List<LottoNumber> createLotto() {
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
