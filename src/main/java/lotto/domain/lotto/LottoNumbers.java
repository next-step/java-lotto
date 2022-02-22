package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatches(final List<LottoNumber> comparison) {
        return (int) numbers.stream()
            .filter(comparison::contains)
            .count();
    }

    public boolean hasBonus(final LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int size() {
        return numbers.size();
    }
}
