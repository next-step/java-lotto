package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public boolean checkValidTickets() {
        return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
    }

    public int numberOfMatching(List<Integer> winningNumber) {
        return (int) winningNumber.stream().filter(w -> numbers.contains(w)).count();
    }

    public String numbersToString() {
        return "[" + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
