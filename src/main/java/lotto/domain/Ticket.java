package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<Integer> numbers;

    public Ticket(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Ticket(String stringNumbers) {
        Set<Integer> numbers = parseToNumbers(stringNumbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private Set<Integer> parseToNumbers(String stringNumbers) {
        Set<Integer> numbers = new HashSet<>();
        String[] splitNumbers = stringNumbers.split(", ");
        for(String number: splitNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public String rendering() {
        return "["+ this.numbers.stream().map(number -> Integer.toString(number)).sorted().collect(Collectors.joining(", ")) + "]";
    }

    public int overlapNumberCount(Ticket otherTicket) {
        Set<Integer> copyThisNumbers = new HashSet<>(this.numbers);
        //otherTicket.numbers.containsAll(this.numbers)
        copyThisNumbers.containsAll(otherTicket.numbers);
        return 12 - copyThisNumbers.size();
    }
}
