package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserTicket {
    private final Set<Integer> numbers;

    public UserTicket(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public UserTicket(String stringNumbers) {
        Set<Integer> numbers = parseToNumbers(stringNumbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private static int overlapCount(Set<Integer> copyThisNumbers) {
        return 12 - copyThisNumbers.size();
    }

    private Set<Integer> parseToNumbers(String stringNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (String number : stringNumbers.split(", ")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public int countMatchNumbers(UserTicket otherUserTicket) {
        Set<Integer> copyThisNumbers = new HashSet<>(this.numbers);
        copyThisNumbers.addAll(otherUserTicket.numbers);
        return overlapCount(copyThisNumbers);
    }

    public WinnerTicket winnerTicket(int bonusNumber) {
        return new WinnerTicket(new HashSet<>(this.numbers), bonusNumber);
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

    public int countWinner(List<UserTicket> challengeUserTickets, Prize prize) {
        int count = 0;
        for (UserTicket userTicket : challengeUserTickets) {
            count = count + (prize.isMatch(this.countMatchNumbers(userTicket)) ? 1 : 0);
        }
        return count;
    }
}
