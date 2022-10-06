package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumbers(numbers);

        this.numbers = numbers;
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public Rank rank(Lotto winningLotto, LottoNumber bonusNumber) {
        return Rank.of(matchedCount(winningLotto), matched(bonusNumber));
    }

    private Integer matchedCount(Lotto another) {
        return another.numbers
                .stream()
                .map(LottoNumber::number)
                .reduce(0, this::accumulateMatchedCount);
    }

    private Integer accumulateMatchedCount(Integer total, Integer number) {
        if (matched(new LottoNumber(number))) {
            return total + 1;
        }
        return total;
    }

    private boolean matched(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            String message = "로또 숫자는 %s개 이어야 합니다.";
            throw new IllegalArgumentException(String.format(message, SIZE));
        }
    }
}
