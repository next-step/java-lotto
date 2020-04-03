package lotto;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

class LottoNumbers {
    private static final int NUMBER_SIZE = LottoRule.COUNT.getValue();

    private final Set<LottoNo> numbers;

    public LottoNumbers(Set<LottoNo> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = Collections.unmodifiableSet(numbers);
    }

    private void validateWinningNumbers(Set<LottoNo> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("다른 숫자를 여섯개 입력해주세요.");
        }
    }

    public Set<LottoNo> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof LottoNumbers)) { return false; }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(getNumbers(), that.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbers());
    }
}
