package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("번호는 6개만 지정 가능 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
