package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<LottoNumber> getNumbers() {
        return numbers;
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
