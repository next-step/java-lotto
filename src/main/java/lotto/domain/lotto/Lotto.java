package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DUPLICATE_NUMBER_MESSAGE = "중복된 번호가 있습니다";

    private List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    private void validateLotto(List<LottoNumber> numbers) {
        long excludingDuplicatedSize = numbers.stream()
            .map(LottoNumber::getNumber)
            .distinct()
            .count();

        if (numbers.size() != excludingDuplicatedSize) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }
}
