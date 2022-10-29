package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_AMOUNT = 6;

    private final LottoNumbers numbers;

    public Lotto(final LottoNumbers numbers) {
        validateOrThrow(numbers.getLottoNumbers());
        this.numbers = numbers;
    }

    public Lotto(final List<LottoNumber> numbers) {
        validateOrThrow(numbers);
        this.numbers = new LottoNumbers(numbers);
    }

    private static void validateOrThrow(final List<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d개이여야 합니다.", LOTTO_NUMBER_AMOUNT));
        }

        if (new HashSet<>(numbers).size() < LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
    }

    public int matchNumberCount(final LottoNumbers winningLottoNumbers) {
        return this.numbers.countOfMatch(winningLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "[" +
                this.numbers.getLottoNumbers()
                            .stream()
                            .sorted()
                            .map(LottoNumber::toString)
                            .collect(Collectors.joining(", ")) +
                "]";
    }
}
