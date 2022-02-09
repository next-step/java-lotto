package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DUPLICATE_NUMBER_MESSAGE = "중복된 번호가 있습니다";

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void validateLotto(List<LottoNumber> numbers) {
        long excludingDuplicatedSize = numbers.stream()
            .distinct()
            .count();

        if (numbers.size() != excludingDuplicatedSize) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers.stream()
            .map(LottoNumber::get)
            .collect(Collectors.toList());
    }
}
