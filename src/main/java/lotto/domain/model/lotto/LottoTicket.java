package lotto.domain.model.lotto;

import java.util.*;

public class LottoTicket {

    private static final int TICKET_NUMBER_COUNT = 6;
    private final Set<LottoNumber> numbers;

    public LottoTicket(final Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void validate(final Set<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != TICKET_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 반드시 %d개의 숫자로 구성되어야 합니다.", TICKET_NUMBER_COUNT));
        }
    }

    public boolean contains(final LottoNumber number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(final LottoTicket other) {
        return (int) numbers.stream().filter(other::contains).count();
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
