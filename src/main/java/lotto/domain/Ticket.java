package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<Integer> numbers;

    public Ticket(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Ticket(String string) {

    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public String rendering() {
        return "["+ String.join(", ", this.numbers.stream().map(number -> Integer.toString(number)).collect(Collectors.toList())) + "]";
    }
}
