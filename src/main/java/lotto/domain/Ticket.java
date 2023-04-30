package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<LottoNumber> numbers;

    public Ticket(Set<Integer> numbers) {
        this.numbers = parseToLottoNumbers(numbers);
        validate();
    }

    public Ticket(String stringNumbers) {
        this.numbers = parseToLottoNumbers(parseToNumbers(stringNumbers));
        validate();
    }

    private Set<LottoNumber> parseToLottoNumbers(Set<Integer> numbers) {
        throw new RuntimeException("Not Yet Implemented");
    }

    private static int overlapCount(Set<LottoNumber> copyThisNumbers) {
        return 12 - copyThisNumbers.size();
    }

    private Set<Integer> parseToNumbers(String stringNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (String number : stringNumbers.split(", ")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validate() {
        if (this.numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public int countMatchNumbers(Ticket otherTicket) {
        Set<LottoNumber> copyThisNumbers = new HashSet<>(this.numbers);
        copyThisNumbers.addAll(otherTicket.numbers);
        return overlapCount(copyThisNumbers);
    }

    public WinnerTicket winnerTicket(int bonusNumber) {
        return new WinnerTicket(this, bonusNumber);
    }

    @Override
    public String toString() {
        return this.numbers
                .stream()
                .map(number -> Integer.toString(number.getLottoNumber()))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Boolean includeNumber(Integer bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public int countWinner(List<Ticket> challengeTickets, Prize prize) {
        int count = 0;
        for (Ticket ticket : challengeTickets) {
            count = count + (prize.isMatch(this.countMatchNumbers(ticket)) ? 1 : 0);
        }
        return count;
    }
}
