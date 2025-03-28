package lotto.domain.model;

import java.util.*;

public class LottoTicket {

    private static final int TICKET_NUMBER_COUNT = 6;
    private final Set<Integer> numbers;

    public LottoTicket(final Set<Integer> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void validate(final Set<Integer> numbers) {
        if (numbers == null || numbers.size() != TICKET_NUMBER_COUNT) {
            final String EXCEPTION_MESSAGE_FORMAT = "로또 번호는 반드시 %d개의 숫자로 구성되어야 합니다.";

            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FORMAT, TICKET_NUMBER_COUNT));
        }
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
