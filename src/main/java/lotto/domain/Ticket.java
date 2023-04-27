package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.List;
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
        for (String number : splitNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public int overlapNumberCount(Ticket otherTicket) {
        Set<Integer> copyThisNumbers = new HashSet<>(this.numbers);
        copyThisNumbers.addAll(otherTicket.numbers);
        return 12 - copyThisNumbers.size();
    }

    public WinnerTicket winnerTicket(int bonusNumber) {
        Set<Integer> copyNumbers = new HashSet<>(this.numbers);
        return new WinnerTicket(copyNumbers, bonusNumber);
    }

    @Override
    public String toString() {
        return this.numbers
                .stream()
                .map(number -> Integer.toString(number))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Boolean includeNumber(Integer bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public int countWinner(List<Ticket> challengeTickets, Prize prize) {
        int count = 0;
        for(Ticket ticket : challengeTickets) {
            count = count + (prize.isMatch(this.overlapNumberCount(ticket)) ? 1 : 0);
        }
        return count;
    }
}
