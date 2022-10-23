package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.generate;

public class Lotto {
    static final int VALID_SIZE = 6;
    private static final String INVALID_SIZE_MESSAGE = "로또 번호 1~45 사이 자연수 6개 입력해주세요.";

    private final Set<LottoNumber> numbers;

    public Lotto() {
        this(generate());
    }

    public Lotto(String numbers) {
        this(generate(numbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
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

    private void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != VALID_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }
}
